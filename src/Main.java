
import cli.Cli;
import controller.BillController;
import controller.TicketController;
import repositories.*;
import service.BillService;
import service.TicketService;
import Strategies.SlotAssignmentStrategyFactory;

public class Main {
    public static void main(String[] args) {
        // Repositories
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        BillRepository billRepository = new BillRepository();

        // Services
        SlotAssignmentStrategyFactory slotAssignmentStrategyFactory = new SlotAssignmentStrategyFactory();
        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
        );
        BillService billService = new BillService(
                ticketRepository,
                billRepository,
                gateRepository
        );

        // Controllers
        TicketController ticketController = new TicketController(ticketService);
        BillController billController = new BillController(billService);

        // CLI
        Cli cli = new Cli(ticketController, billController);
        cli.start();
    }
}