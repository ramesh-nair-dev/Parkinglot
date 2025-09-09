package repositories;

import models.Bill;
import models.Ticket;

import java.util.Optional;

public class BillRepository {
    int lastBillNumber = 0;


    public int getBillNumber(){
        lastBillNumber = lastBillNumber+1;
        return lastBillNumber;

    }

    public Bill save(Bill bill){
        return  null;
    }
}
