package models;

import java.util.List;

public class ParkingFloor extends BaseClass{
    private int floorNumber;
    private List<ParkingSlot> parkingSlotList;
    private ParkingFloorStatus parkingFloorStatus;
    private List<SupportedVehicleType> supportedVehicleTypeList;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
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
Design Notes for ParkingFloor Model
--------------------------------------

1. Floor Identification:
   - `floorNumber` uniquely identifies each parking floor.
   - Provides deterministic mapping between the physical layout and digital records.

2. Parking Slot Composition:
   - `parkingSlotList` captures the collection of slots on the floor.
   - Establishes a one-to-many relationship (ParkingFloor → ParkingSlot).
   - Enables fine-grained allocation, tracking, and monitoring of vehicles per floor.

3. Operational Status:
   - `parkingFloorStatus` indicates the current availability state of the floor:
     -> OPEN  (available for parking),
     -> FULL  (no available slots),
     -> CLOSED (temporarily out of service).
   - This supports real-time allocation decisions and improves system responsiveness.

4. Vehicle Support:
   - `supportedVehicleTypeList` defines which vehicle categories (e.g., Car, Bike, EV)
     can be accommodated on this floor.
   - Adds flexibility for future extension (e.g., EV charging floors, heavy vehicles).

--------------------------------------
Outcome:
The `ParkingFloor` model encapsulates not just structural data (slots and floor number),
but also operational intelligence (status, supported vehicle types).
This transforms it into a pivotal entity for real-time parking allocation,
capacity planning, and analytics within the parking lot system.
--------------------------------------
*/

