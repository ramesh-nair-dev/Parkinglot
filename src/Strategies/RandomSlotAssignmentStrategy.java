package Strategies;

import models.*;

import java.util.List;

public class RandomSlotAssignmentStrategy implements ParkingSlotStrategy {

    @Override
    public ParkingSlot allotParkingSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for( ParkingFloor parkingFloor : parkingLot.getParkingFloorList()){
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlotList()){
                if(parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) && vehicleType == parkingSlot.getVehicleType()){
                    parkingSlot.setParkingSlotStatus(ParkingSlotStatus.FILLED);
                    return parkingSlot;
                }
            }

        }

        return null;
    }
}
/*
what are we doing here is that we have randomAssingment Strategy where where do give first empty slot we get
we interate over all parking floor inside all parking floor we iterate over all slot inside check a match is it empty and does vehcile type matches
 */
