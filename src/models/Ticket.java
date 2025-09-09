package models;

import java.util.Date;

public class Ticket extends BaseClass{
    private Date entryTime;
    private ParkingSlot parkingSlotAlloted;
    private Vehicle vehicleDetails;
    private Gate gateNumber;
    private Operator operator;
    private FareStrategyType fareStrategyType;

    public FareStrategyType getFareStrategyType() {
        return fareStrategyType;
    }

    public void setFareStrategyType(FareStrategyType fareStrategyType) {
        this.fareStrategyType = fareStrategyType;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSlot getParkingSlotAlloted() {
        return parkingSlotAlloted;
    }

    public void setParkingSlotAlloted(ParkingSlot parkingSlotAlloted) {
        this.parkingSlotAlloted = parkingSlotAlloted;
    }

    public Vehicle getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(Vehicle vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Gate getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Gate gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}

/*
Ticket Entity – Design Rationale

1. Entry Timestamp → `entryTime` captures the exact time a vehicle entered.
   - Essential for fare calculation.
   - Supports analytics like average parking duration.

2. Parking Slot Mapping → `parkingSlotAlloted` links the ticket with a physical slot.
   - Ensures slot tracking and avoids double-booking.
   - Helps locate the vehicle at exit.

3. Vehicle Details → `vehicleDetails` captures metadata (plate number, type, etc.).
   - Enables enforcement and auditing.
   - Can be extended to support smart features like ANPR (Automatic Number Plate Recognition).

4. Entry Gate → `gateNumber` records which gate was used.
   - Useful for traffic flow monitoring and load balancing across multiple gates.
   - Helps in post-incident tracing (e.g., disputes or security checks).

5. Operator on Duty → `operator` links the human/system issuing the ticket.
   - Provides accountability and traceability.
   - Supports shift-based reporting.

6. Fare Strategy → `fareStrategyType` determines the pricing model applied (flat rate, hourly, dynamic pricing, etc.).
   - Makes the system extensible to plug in new pricing rules without redesigning the ticket structure.

Why this matters?
The `Ticket` acts as the **contract** between the parking system and the customer.
It bridges multiple domains — parking allocation, pricing, operations, and audit.
By designing it with slots, operators, gates, and fare strategy, we ensure this entity scales seamlessly from a **mall parking lot** to a **smart city-wide parking network**.

 */
