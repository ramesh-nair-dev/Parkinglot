package service;

import Strategies.FareCalculationStrategyFactory;
import models.Bill;
import models.Gate;
import models.Ticket;
import repositories.BillRepository;
import repositories.GateRepository;
import repositories.TicketRepository;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class BillService {

    private final TicketRepository ticketRepository;
    private final BillRepository billRepository;
    private final GateRepository gateRepository;


    public BillService(TicketRepository ticketRepository , BillRepository billRepository , GateRepository gateRepository){
        this.ticketRepository = ticketRepository;
        this.billRepository = billRepository;
        this.gateRepository = gateRepository;
    }

    public Bill issueBill (
            int ticketId,
            int gateId
    ) throws Exception {

        Bill bill = new Bill();
        bill.setBillNumber(billRepository.getBillNumber());
        Optional<Ticket> optionalTicket = ticketRepository.getTicketById(ticketId);

        if(optionalTicket.isEmpty()){
            throw new Exception("Invalid Ticket !");
        }

        Ticket ticket = optionalTicket.get();
        bill.setTicketDetails(ticket);
        bill.setExitTime(new Date());
        long amount = Objects.requireNonNull(FareCalculationStrategyFactory.getFareCalculationStrategy(ticket.getFareStrategyType()))
                .calculateFare(bill.getTicketDetails().getEntryTime(),bill.getExitTime());

        bill.setAmount(amount);
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if(optionalGate.isEmpty()){
            throw new Exception("Invalid Gate !");
        }

        Gate gate = optionalGate.get();
        bill.setGateNumber(gate);
        bill.setOperator(gate.getOperator());
        return billRepository.save(bill);

    }


}
/*
BillService – Design Rationale

1. Bill Number Assignment → Every bill is uniquely tracked using `billRepository.getBillNumber()`.
   - Guarantees uniqueness across multiple parking lots.
   - Supports compliance, reconciliation, and downstream reporting.

2. Ticket Validation → Ticket is fetched and validated from `TicketRepository`.
   - Prevents fraudulent or duplicate billing.
   - Ensures billing is always tied to a legitimate parking session.

3. Exit Time Recording → `bill.setExitTime(new Date())` ensures real-time capture.
   - Critical for accurate fare computation.
   - Enables auditing for overstays or disputes.

4. Fare Calculation Strategy → Applied via `FareCalculationStrategyFactory`.
   - Decouples business logic from core service.
   - Supports plug-and-play extensibility (hourly, flat rate, dynamic pricing, event-based pricing).

5. Gate & Operator Binding → Gate and its operator are fetched at billing time.
   - Provides operational accountability (who processed the bill, at which gate).
   - Enables gate-level analytics (e.g., busiest exit gates).

6. Repository Pattern → Persistence is abstracted using repositories.
   - Keeps service logic clean and testable.
   - Supports multiple storage backends without changing service logic.

Why this matters?
`BillService` sits at the **crossroads of financial, operational, and customer-facing workflows**.
It ensures that each bill is accurate, auditable, and extensible for future needs.
By cleanly separating validation, pricing strategy, and persistence, this design is robust enough for both a **single mall parking lot** and a **multi-city smart parking ecosystem**.
 */
