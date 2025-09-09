package Strategies;

import models.FareStrategyType;

public class FareCalculationStrategyFactory {
    public static FareCalculationStrategy getFareCalculationStrategy(FareStrategyType fareStrategyType){
        if(fareStrategyType.equals(FareStrategyType.WEEKDAY)){
            return new WeekDaysFareStrategy();
        }

        return null;
    }
}
