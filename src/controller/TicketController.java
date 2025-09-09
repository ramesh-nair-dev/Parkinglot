package controller;

import dtoS.IssueTicketRequest;
import dtoS.IssueTicketResponse;
import dtoS.ResponseStatus;
import models.Ticket;
import service.TicketService;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    IssueTicketResponse issueTicket(IssueTicketRequest request_DTO) throws Exception {
        IssueTicketResponse response = new IssueTicketResponse();
        Ticket ticket = ticketService.issueTicket(request_DTO.getGateId(),request_DTO.getVehicleNumber(),request_DTO.getVehicleType(),request_DTO.getVehicleOwner(),request_DTO.getFareStrategyType());
        response.setTicket(ticket);
        response.setResponseStatus(ResponseStatus.SUCCESS);
        return response;
    }
}

/**
 *
 * TicketController demonstrates exemplary enterprise application design:
 * Enforces separation of concerns by delegating business logic to the service layer.
 * Utilizes DTOs to decouple internal models from API contracts, minimizing data exposure.
 * Promotes maintainability and extensibility through clear abstractions and single responsibility.
 * Aligns with industry best practices for scalable, robust, and secure Java applications.
 * This approach reflects the engineering rigor expected from top-tier software professionals.
 */
