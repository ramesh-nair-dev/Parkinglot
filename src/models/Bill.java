package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseClass{
    private int billNumber;
    private Ticket ticketDetails;
    private Date exitTime;
    private long amount;
    private Gate gateNumber;
    private Operator operator;
    private List<Payment> paymentList;

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public Ticket getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(Ticket ticketDetails) {
        this.ticketDetails = ticketDetails;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}

/*
Bill class stores comprehensive billing information for a parking system:
1. Unique bill identifier for traceability.
2. Associated Ticket object to capture vehicle entry details, enabling accurate fare calculation.
3. Exit timestamp to determine parking duration.
4. Computed total amount based on entry and exit times.
5. Reference to the Gate entity representing the exit point.
6. Operator responsible for processing the transaction, ensuring accountability.
7. List of Payment objects to support multi-mode and partial payments (e.g., split between cash, UPI, card), and to handle scenarios like payment retries or failures, ensuring robust and auditable payment tracking.
*/
