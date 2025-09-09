package Strategies;

import models.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static ParkingSlotStrategy getParkingSlotAssignmentStrategy(String strategyType){
        if(strategyType.equals(SlotAssignmentStrategyType.RANDOM)){
            return new RandomSlotAssignmentStrategy();
        }
        return null;
    }
}
