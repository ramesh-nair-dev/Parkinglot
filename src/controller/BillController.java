package controller;

import dtoS.IssueBillRequest;
import dtoS.IssueBillResponse;
import dtoS.ResponseStatus;
import models.Bill;
import service.BillService;

public class BillController {
    private final BillService billService;

    public BillController(BillService billService){
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
