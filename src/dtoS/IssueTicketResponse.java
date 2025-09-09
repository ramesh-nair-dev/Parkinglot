package dtoS;

import models.Ticket;

public class IssueTicketResponse {
    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String setFailureMessage;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getSetFailureMessage() {
        return setFailureMessage;
    }

    public void setSetFailureMessage(String setFailureMessage) {
        this.setFailureMessage = setFailureMessage;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}

/*
in our response DTO when client will call the controller hey i want to issue a ticket it call issueTicket function
in our controller in response to that we will send response DTO with desied info we want that is we want sending ticket
object
 */