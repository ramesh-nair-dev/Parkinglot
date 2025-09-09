package models;

public class Gate extends BaseClass{
    private int gateNumber;
    private GateType gateType;
    private Operator operator;
    private int parkingLotId;

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}

/*
--------------------------------------
💡 Design Notes for Gate Class
--------------------------------------

The `Gate` entity in a parking lot system should capture operationally critical attributes
that ensure flexibility, scalability, and accurate historical tracking:

1. Gate Identification:
   - Each gate should have a unique `gateNumber` for clear distinction within the parking lot.
   - This enables unambiguous mapping between physical gates and their digital representation.

2. Gate Type (Entry / Exit):
   - A gate should maintain its configured `GateType`.
   - Real-world requirement: malls or event venues often re-purpose gates dynamically
     (e.g., during peak traffic after a popular 9:00 PM movie, exit gates may temporarily
     be converted into entry gates to reduce choke points).
   - Designing for this flexibility ensures the system can adapt without structural changes.

3. Operator Association:
   - The gate should log which `Operator` was assigned at any given time.
   - This is crucial for:
     -> Auditing (who was responsible at a specific time),
     -> Accountability (dispute resolution, fraud detection),
     -> Analytics (performance metrics per operator).

--------------------------------------
✅ Outcome:
By capturing these attributes (gate number, type, and operator assignment),
the `Gate` class evolves from a simple structural element into a robust
auditable entity aligned with real-world operational needs.
--------------------------------------
*/







