package Strategies;

import models.FareStrategyType;

import java.util.Date;

public class WeekDaysFareStrategy implements FareCalculationStrategy{
    @Override
    public long calculateFare(Date entryTime, Date existTime) {
        long diffMillis = existTime.getTime() - entryTime.getTime();
        long totalMinutes = diffMillis / (1000 * 60);
        long totalHours = (long) Math.ceil(totalMinutes / 60.0); // always round up

        // Apply fare logic
        if (totalHours <= 1) {
            return 30;
        } else if (totalHours <= 3) {
            return 50;
        } else if (totalHours <= 6) {
            return 100;
        } else if (totalHours <= 12) {
            return 150;
        } else {
            return 200 + (totalHours - 12) * 10; // ₹10 for each hour after 12
        }

    }
}
