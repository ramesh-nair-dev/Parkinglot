package Strategies;

import models.ParkingLot;
import models.ParkingSlot;
import models.VehicleType;

public interface ParkingSlotStrategy {
    public ParkingSlot allotParkingSlot(ParkingLot parkingLot , VehicleType vehicleType);

    /*
    to allot a parking slot what details we will need we will parkinglot from there can get floor and slot and
    we also need what is the vehicle type of the
     */
}
