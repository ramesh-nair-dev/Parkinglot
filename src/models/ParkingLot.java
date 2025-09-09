package models;

import Strategies.ParkingSlotStrategy;

import java.util.List;

public class ParkingLot extends BaseClass{
    private String parkingLotName;
    private List<ParkingFloor> parkingFloorList;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> entryGateList;
    private List<Gate> exitGateList;
    private List<SupportedVehicleType> supportedVehicleTypeList;
    private String parkingSlotStrategy;

    public String getParkingSlotStrategy() {
        return parkingSlotStrategy;
    }

    public void setParkingSlotStrategy(String parkingSlotStrategy) {
        this.parkingSlotStrategy = parkingSlotStrategy;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Gate> getEntryGateList() {
        return entryGateList;
    }

    public void setEntryGateList(List<Gate> entryGateList) {
        this.entryGateList = entryGateList;
    }

    public List<Gate> getExitGateList() {
        return exitGateList;
    }

    public void setExitGateList(List<Gate> exitGateList) {
        this.exitGateList = exitGateList;
    }

    public List<SupportedVehicleType> getSupportedVehicleTypeList() {
        return supportedVehicleTypeList;
    }

    public void setSupportedVehicleTypeList(List<SupportedVehicleType> supportedVehicleTypeList) {
        this.supportedVehicleTypeList = supportedVehicleTypeList;
    }
}

/*

--------------------------------------
Design Notes for ParkingLot Model
--------------------------------------

From an overview perspective, the `ParkingLot` entity must capture both
identification and operational details to support multi-lot management
within a single system.

1. Unique Identification:
   - Every parking lot must maintain a globally unique `id` (inherited from BaseClass).
   - Required because our system may manage multiple parking lots across locations.
   - All lots are stored in a shared database; unique IDs prevent collisions.

2. Name / Branding:
   - `parkingLotName` provides a human-readable identifier for operations,
     reporting, and customer-facing interfaces.

3. Structural Composition:
   - `parkingFloorList` captures all floors belonging to the lot.
   - Enables hierarchical modeling (ParkingLot → Floors → Slots).
   - Critical for computing overall capacity and distributing traffic.

4. Operational Status:
   - `parkingLotStatus` indicates whether the entire lot is OPEN, CLOSED, or UNDER_MAINTENANCE.
   - Supports system-wide routing decisions and user notifications.

5. Entry & Exit Gates:
   - `entryGateList` and `exitGateList` model the multiple ingress and egress points.
   - Mirrors real-world parking lots where multiple gates balance load.
   - Enables gate-level monitoring, choke-up handling, and operator assignment.

6. Vehicle Capacity & Type Support:
   - `supportedVehicleTypeList` stores category-wise capacity, e.g.:
       -> { BIKE: 50, CAR: 100, EV: 20 }
   - This supports:
       -> Fine-grained allocation per vehicle type,
       -> Real-time occupancy tracking,
       -> Future scalability (new categories like trucks or EV-charging).

7. Slot Allocation Strategy:
   - `parkingSlotStrategy` defines how vehicles are assigned slots
     (e.g., nearest-available, first-come-first-serve, optimized load balancing).
   - Strategy-driven design (Strategy Pattern) makes the system configurable
     without altering core logic.

--------------------------------------
Outcome:
The `ParkingLot` entity is not just a container of floors and gates.
It becomes a **high-level orchestration unit** that:
   - Uniquely identifies each lot in a multi-tenant system,
   - Manages its structure, operational state, and gate flows,
   - Provides category-wise capacity tracking,
   - And leverages allocation strategies for intelligent parking.

This ensures scalability, flexibility, and alignment with real-world parking operations.
--------------------------------------
*/

