
package cli;

import controller.BillController;
import controller.TicketController;
import dtoS.IssueBillRequest;
import dtoS.IssueBillResponse;
import dtoS.IssueTicketRequest;
import models.VehicleType;

import java.util.Scanner;

public class Cli {
    private final TicketController ticketController;
    private final BillController billController;
    private final Scanner scanner;

    public Cli(TicketController ticketController, BillController billController) {
        this.ticketController = ticketController;
        this.billController = billController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=================================================");
        System.out.println("      🚗 Welcome to Parking Lot System      ");
        System.out.println("=================================================");
        System.out.println();

        while (true) {
            System.out.println("Commands:");
            System.out.println("  park <vehicle_number> <vehicle_type (CAR, BIKE, etc.)>");
            System.out.println("  unpark <ticket_id>");
            System.out.println("  exit");
            System.out.print("> ");

            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "park":
                    if (parts.length < 3) {
                        System.out.println("Invalid command. Usage: park <vehicle_number> <vehicle_type>");
                    } else {
                        try {
                            IssueTicketRequest request = new IssueTicketRequest();
                            request.setVehicleNumber(parts[1]);
                            request.setVehicleType(VehicleType.valueOf(parts[2].toUpperCase()));
                            request.setGateId(1);
                            ticketController.issueTicket(request);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid vehicle type. Supported types: CAR, BIKE");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "unpark":
                    if (parts.length < 2) {
                        System.out.println("Invalid command. Usage: unpark <ticket_id>");
                    } else {
                        try {
                            IssueBillRequest request = new IssueBillRequest();
                            request.setTicketId(Integer.parseInt(parts[1]));
                            request.setGateId(2); // Assuming exit gate ID is 2
                            IssueBillResponse response = billController.issueBill(request);
                            System.out.println("Bill issued successfully:");
                            System.out.println("  Bill Number: " + response.getBillNumber());
                            System.out.println("  Fare: " + response.getFare());
                            System.out.println("  Entry Time: " + response.getEntryTime());
                            System.out.println("  Exit Time: " + response.getExitTime());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ticket ID. It must be a number.");
                        } catch (Exception e) {
                            System.out.println("Error issuing bill: " + e.getMessage());
                        }
                    }
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
            System.out.println();
        }
    }
}
