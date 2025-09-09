package models;

public class ParkingSlot extends BaseClass{
    private int SlotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private VehicleType vehicleType;

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        SlotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

/*
ParkingSlot Design Considerations

1. Slot Identification → Each slot is uniquely identified using a `slotNumber`.
   This helps in mapping real-world physical slots to the system representation.

2. Occupancy Tracking → `parkingSlotStatus` allows us to track availability in real time.
   This is crucial for efficient slot allocation and avoiding conflicts during booking.

3. Vehicle Type Binding → A slot may be restricted to specific vehicle categories
   (e.g., bikes-only, cars-only, EV-charging). By associating each slot with a `vehicleType`,
   we enforce rules at the data model level, ensuring accurate allocation and capacity planning.

Why this matters?
This abstraction makes the system scalable and flexible. Whether we’re managing a small mall parking area
or a large multi-floor smart parking hub, the `ParkingSlot` entity remains the fundamental building block,
supporting future extensions like EV slots, handicapped parking, or dynamic pricing.
 */
