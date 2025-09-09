package service;

import Strategies.SlotAssignmentStrategyFactory;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class TicketService {
    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(
            int gateId,
            String vehicleNumber,
            VehicleType vehicleType,
            String vehicleOwner,
            FareStrategyType fareStrategyType
    ) throws Exception {
        // initialize new Ticket object
        Ticket ticket = new Ticket();

        // 1. Capture entry time (first thing that happens at entry gate)
        ticket.setEntryTime(new Date());

        // 2. Get gate details from repository (never directly query DB in service layer)
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if (gateOptional.isEmpty()) {
            throw new Exception("Gate not found !");
        }
        Gate gate = gateOptional.get();
        ticket.setGateNumber(gate);
        ticket.setOperator(gate.getOperator());  // Operator logged for accountability

        // 3. Set fare strategy (different lots might have hourly/flat/dynamic pricing)
        ticket.setFareStrategyType(fareStrategyType);

        // 4. Attach vehicle details.
        //    - If vehicle exists, fetch it.
        //    - If not, register it first (system should always maintain vehicle master data).
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if (vehicleOptional.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleOwner(vehicleOwner);
            vehicle = vehicleRepository.save(vehicle); // persist new vehicle
        } else {
            vehicle = vehicleOptional.get();
        }
        ticket.setVehicleDetails(vehicle);

        // 5. Assign parking slot via strategy (decouples allocation logic from service).
        int parkingLotId = gate.getParkingLotId();
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findParkingLotById(parkingLotId);
        if (optionalParkingLot.isEmpty()) {
            throw new Exception("Invalid Parking Lot");
        }
        ParkingLot parkingLot = optionalParkingLot.get();
        ParkingSlot parkingSlot = Objects.requireNonNull(
                SlotAssignmentStrategyFactory.getParkingSlotAssignmentStrategy(parkingLot.getParkingSlotStrategy())
        ).allotParkingSlot(parkingLot, vehicleType);
        ticket.setParkingSlotAlloted(parkingSlot);

        // 6. Save and return the fully initialized Ticket
        return ticketRepository.save(ticket);
    }

    /*
    TicketService – Business Logic Breakdown
    1. Entry Time → Every ticket starts with a timestamp (audit + billing foundation).
    2. Gate Validation → Gate ID is resolved through repository, ensuring clean separation from DB queries.
    3. Operator Linking → The on-duty operator is bound to ticket for accountability.
    4. Fare Strategy → Strategy pattern allows dynamic pricing policies per parking lot.
    5. Vehicle Handling → System ensures vehicle is always in DB:
         - Existing vehicles reused.
         - New vehicles registered seamlessly.
    6. Parking Slot Assignment → Delegated to SlotAssignmentStrategyFactory:
         - Allows flexible allocation policies (nearest available, first free, VIP slots, etc.).
    7. Ticket Persistence → Finalized ticket is saved for traceability.

    Why this design?
    - Keeps service lean, focused only on orchestration.
    - Pushes decision-making into strategies + repositories for testability and extensibility.
    - This ensures the ticketing flow works for a single mall parking lot today,
      and a smart-city scale distributed parking ecosystem tomorrow.
    */
}
