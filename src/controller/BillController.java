package controller;

import dtoS.IssueBillRequest;
import dtoS.IssueBillResponse;
import dtoS.ResponseStatus;
import models.Bill;
import service.BillService;

public class BillController {
    private final BillService billService;

    BillController(BillService billService){
        this.billService = billService;
    }

    public IssueBillResponse issueBill(IssueBillRequest billRequest) throws Exception {

        IssueBillResponse issueBillResponse = new IssueBillResponse();

        Bill bill = billService.issueBill(billRequest.getTicketId(), billRequest.getGateId());
        issueBillResponse.setBillId(bill.getId());
        issueBillResponse.setEntryTime(bill.getTicketDetails().getEntryTime());
        issueBillResponse.setExitTime(bill.getExitTime());
        issueBillResponse.setBillNumber(bill.getBillNumber());
        issueBillResponse.setFare(bill.getAmount());
        issueBillResponse.setResponseStatus(ResponseStatus.SUCCESS);

        return issueBillResponse;

    }
}


/*

1. Controller Responsibility:
   - This class is a thin orchestration layer between the client (API request/response DTOs) and the service layer.
   - It follows the Single Responsibility Principle:
     -> It does NOT contain business logic, only request handling + mapping to response.

2. Dependency Injection:
   - `BillService` is injected into the controller via constructor.
   - This makes the controller testable (can mock BillService in unit tests).
   - Follows Inversion of Control (IoC) principle.

3. DTO (Data Transfer Objects):
   - Input: `IssueBillRequest` (encapsulates request params like ticketId, gateId).
   - Output: `IssueBillResponse` (maps the domain `Bill` model into a lightweight response).
   - This ensures strong separation of layers and prevents exposing domain internals directly.

4. Service Delegation:
   - `billService.issueBill()` handles all core business rules:
     -> Fare calculation, validation, assigning exit time, generating bill number.
   - Keeps the controller clean and focused on "orchestration", not "business".

5. Mapping Domain to Response:
   - Maps each field explicitly from `Bill` model → `IssueBillResponse`.
   - Explicit mapping prevents accidental leaks of sensitive data.
   - Ensures clients only see the sanitized + necessary fields.

6. Response Status:
   - `ResponseStatus.SUCCESS` provides explicit feedback to the client.
   - Prepares system for extensibility (can add FAILURE, ERROR, etc. in future).

7. Extensibility:
   - To add features like discounts, loyalty points, or custom bill formats:
     -> Extend BillService, keep controller unchanged (Open/Closed Principle).
   - Controller remains stable as the system evolves.

8. Clean Architecture Principles:
   - Controller (I/O layer) ↔ Service (business logic) ↔ Models (domain entities) ↔ DTOs (API contract).
   - Each layer is decoupled, making the system maintainable and scalable.

--------------------------------------
*/
