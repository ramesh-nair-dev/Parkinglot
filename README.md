---

# 🚗 Parking Lot Management System

A modular, extensible, and production-grade **Parking Lot Management System** implemented in Java.
This project demonstrates **clean architecture, design patterns, and scalable system design principles** for solving one of the most common low-level design (LLD) interview problems.

---

## ✨ Highlights

* **Clean Layered Architecture**

  * `models` → Core domain entities (ParkingLot, Vehicle, Ticket, Gate, Operator, etc.)
  * `repositories` → Data access abstraction using in-memory stores (easily swappable with DB later)
  * `service` → Business logic orchestration (`TicketService`, Slot assignment, etc.)
  * `strategies` → Pluggable slot assignment and fare strategies
  * `controller` → Entry point for client requests

* **Design Principles Applied**

  * **SOLID Principles**

    * **Single Responsibility** → Repositories handle persistence, services handle orchestration, strategies handle logic.
    * **Open/Closed Principle** → Add new slot assignment or fare strategies without touching core services.
  * **Strategy Pattern** → Flexible slot allocation & fare calculation.
  * **Factory Pattern** → Centralized slot strategy resolution via `SlotAssignmentStrategyFactory`.
  * **Repository Pattern** → Decouples persistence from business logic.
  * **Polymorphism & Enums** → Clean representation of strategies, vehicle types, and fare policies.

* **Extensibility**

  * Adding a new **vehicle type** (e.g., EV, Truck) → update `VehicleType` enum + strategy logic.
  * Adding a new **fare strategy** (e.g., Surge pricing, Weekend discounts) → implement new strategy class, no service change needed.
  * Adding new **slot allocation logic** (e.g., Nearest slot, Priority-based) → plug into strategy factory.

---

## 📂 Project Structure

```
Parkinglot-main/
│── controller/                # Handles client input (simulating API layer)
│── models/                    # Domain models (Ticket, Vehicle, ParkingLot, etc.)
│── repositories/              # Repository classes (in-memory persistence)
│── service/                   # Business logic layer (TicketService, etc.)
│── strategies/                # Slot assignment & fare calculation strategies
│── Main.java                  # Application entry point (demo run)
```

---

## 🚀 Core Flow (How Ticket Issuance Works)

1. **Vehicle arrives** → Request sent to `TicketService.issueTicket()`.
2. **Gate validation** → Ensures gate exists and operator is logged.
3. **Vehicle registration** → Reuse existing or create new entry in repository.
4. **Slot assignment** → Delegated to `SlotAssignmentStrategyFactory` (strategy-driven).
5. **Fare policy attached** → Ticket links to pricing strategy (flat/hourly/dynamic).
6. **Ticket saved** → Final object persisted in `TicketRepository`.

---

## 🧩 Example: Strategy Flexibility

```java
ParkingSlot parkingSlot = SlotAssignmentStrategyFactory
    .getParkingSlotAssignmentStrategy(parkingLot.getParkingSlotStrategy())
    .allotParkingSlot(parkingLot, vehicleType);
```

* Today → `NearestAvailableSlotStrategy`
* Tomorrow → Add `VIPPrioritySlotStrategy` or `EVChargingSlotStrategy` with **zero service code change**.

---

## 🛠️ How to Run

### Prerequisites

* Java 17+
* Maven

### Steps

```bash
git clone <this-repo>
cd Parkinglot-main
mvn clean install
mvn exec:java -Dexec.mainClass="Main"
```

---

## ✅ Sample Run

```
🚗 Vehicle KA-01-1234 (Car) entered via Gate 2
🎟️ Ticket issued: T-1001
🅿️ Slot assigned: Basement-B2-Slot15
👨 Operator: John Doe
💰 Fare Strategy: HOURLY
```

---

## 🏗️ Future Improvements

* Replace in-memory repositories with **SQL/NoSQL database layer**.
* Add **REST APIs** using Spring Boot for real-world integration.
* Integrate **payment gateway module** (Paytm/Stripe).
* Add **concurrency handling** for multiple gates issuing tickets simultaneously.
* Implement **admin dashboard** to view parking occupancy in real time.

---

## 📚 Why This Project Stands Out

* Shows **end-to-end problem solving**: From requirements → design → working code.
* Uses **enterprise-grade design patterns** in a small codebase.
* Extensible enough to evolve into a **real-world system** (mall, airport, smart city).
* Written with **interview excellence in mind** → Recruiters & interviewers instantly see **scalable design thinking**.

---

## 👨‍💻 Author

**Ramesh Nair**

* Backend Engineer | Java | Spring Boot | System Design Enthusiast
* Focused on building **scalable, maintainable, real-world systems**.
* Passionate about **clean architecture, design patterns, and domain modeling**.

📫 Reach me at: ramesh200212@gmail.com
🌐 GitHub: https://github.com/ramesh-nair-dev

---


