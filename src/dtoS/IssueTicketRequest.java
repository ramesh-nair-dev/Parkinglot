package dtoS;

import models.FareStrategyType;
import models.VehicleType;

public class IssueTicketRequest {
    private int gateId;
    private String VehicleNumber;
    private VehicleType vehicleType;
    private String vehicleOwner;
    private FareStrategyType fareStrategyType;

    public FareStrategyType getFareStrategyType() {
        return fareStrategyType;
    }

    public void setFareStrategyType(FareStrategyType fareStrategyType) {
        this.fareStrategyType = fareStrategyType;
    }

    /*
    In issue ticket DTO what we need to issue a ticket what is the basic requirement we need
    we need the gateId from which it entered , we need the vechicle number and type o the
    vehicle may we also store Owner name but this is optinal above three are neccesay field

    why we need DTO is not expose are model because it contains the thing that we store in out Database that is why
    we create DTO's

     */

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }
}
