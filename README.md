### Prerequisites

* Java 17+

### How to Run the Demo

1.  **Clone the repository:**
    ```bash
    git clone <this-repo>
    cd Parkinglot-main
    ```

2.  **Compile the Java code:**
    ```bash
    mkdir out
    find src -name "*.java" > sources.txt
    javac -d out @sources.txt
    ```

3.  **Run the application:**
    ```bash
    java -cp out Main
    ```

4.  The application will start in interactive mode.

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

## 🚀 Live Interactive Demo

This project now features a fully interactive Command-Line Interface (CLI) to demonstrate the parking lot's functionality in real-time. This is the best way to see the design patterns and business logic in action.

### Interactive Commands

Once the demo is running, you can use the following commands:

*   `park <vehicle_number> <vehicle_type>`: Parks a vehicle and issues a ticket.
    *   Example: `park KA-01-HH-1234 CAR`
*   `unpark <ticket_id>`: Calculates the fare and marks the slot as available.
*   `exit`: Exits the application.

### Demo Output Example

```
=================================================
      🚗 Welcome to Parking Lot System      
=================================================

Commands:
  park <vehicle_number> <vehicle_type (CAR, BIKE, etc.)>
  unpark <ticket_id>
  exit
> park MH-12-BF-4567 BIKE

Issuing ticket for vehicle MH-12-BF-4567 with type BIKE at gate 1
Ticket issued successfully with ticket id: 1

Commands:
  park <vehicle_number> <vehicle_type (CAR, BIKE, etc.)>
  unpark <ticket_id>
  exit
> 
```

This interactive demo clearly showcases the system's core functionality and provides a hands-on experience of the application's capabilities, which is great for impressing recruiters.

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
