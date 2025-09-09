package Strategies;

import models.FareStrategyType;

import java.util.Date;

public interface FareCalculationStrategy {
    public long calculateFare(Date entryTime , Date existTime);
}
