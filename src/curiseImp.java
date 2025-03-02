import javax.swing.JOptionPane;

public class curiseImp {
    public static void main(String[] args) {
        final int maxNumOfCruise = 10;
        cruise[] allCruise = new cruise[maxNumOfCruise];// setting the array for cruise
        int choice = 0;
        // menu using do-while and switch case
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "Choose one of the following option: \n1. Create Cruise \n2. Search Cruise \n3. Remove Cruise \n4. Sell Cruise Ticket \n5. Display All Cruise \n6. Exit \n Enter your choice"));
            switch (choice) {
                case 1:
                    allCruise[cruise.getCurrentNumOfCruise()] = createCruise();
                    break;
                case 2:
                    String searchID = JOptionPane.showInputDialog("Enter the cruise ID you are looking for ");
                    int found = searchCruise(allCruise, searchID);
                    if (found > -1)
                        JOptionPane.showMessageDialog(null, "The cruise found " + allCruise[found].toString());
                    else
                        JOptionPane.showMessageDialog(null, "The cruise not found");
                    break;
                case 3:
                    removeCruise(allCruise);
                    break;
                case 4:
                    sellCruiseTicket(allCruise);
                    break;
                case 5:
                    displayAllCruise(allCruise);
                    break;
                case 6:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Incorrect choice! Try again");
            }
        } while (choice >= 1 && choice <= 6);
        displayAllCruise(allCruise);
    } // end of main

    // Create Cruise
    public static cruise createCruise() {
        // we are getting the input and set it
        cruise aCruise = new cruise();

        try {
            String cruiseID = JOptionPane.showInputDialog("Enter cruise ID");
            aCruise.setCruiseID(cruiseID);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            String route = JOptionPane.showInputDialog("Enter route");
            aCruise.setRoute(route);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            int ticketPrice = Integer.parseInt(JOptionPane.showInputDialog("Enter ticket price"));
            aCruise.setTicketPrice(ticketPrice);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! ticket price must be a number");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return aCruise;
    }// end of create cruise

    public static int searchCruise(cruise[] allCruise, String cruiseID) {
        int searchIndex = -1;
        for (int i = 0; i < cruise.getCurrentNumOfCruise(); i++) {
            if ((allCruise[i].getCruiseID()).equalsIgnoreCase(cruiseID)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;

    }

    public static void removeCruise(cruise[] allCruise) {
        displayAllCruise(allCruise);
        String cruiseToRemove = JOptionPane.showInputDialog("Enter the cruise ID to delate");
        int index = searchCruise(allCruise, cruiseToRemove);
        for (int i = index; i < cruise.getCurrentNumOfCruise(); i++) {
            allCruise[i] = allCruise[i + 1];
        }
        allCruise[cruise.getCurrentNumOfCruise()] = null;
        cruise.updateNumOfCruise();
    }

    public static void sellCruiseTicket(cruise[] allCruise) {

        String cruiseID = JOptionPane.showInputDialog("Enter Cruise ID to book tickets:");
        int index = searchCruise(allCruise, cruiseID);

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Cruise not found");
            return;
        }
        try {
            int ticketSelected = Integer.parseInt(JOptionPane.showInputDialog("How many tickets would like to buy"));
            if (ticketSelected <= 0) {
                JOptionPane.showMessageDialog(null, "Error! Ticket number must be greater than zero.");
                return;
            }
            int availableSeats = cruise.maxNumOfPassenger - allCruise[index].getTicketSold();
            if (ticketSelected > availableSeats) {
                JOptionPane.showMessageDialog(null,
                        "Not enough seats available, only " + availableSeats + " seats available");
                return;
            }
            allCruise[index].setTicketSold(allCruise[index].getTicketSold() + ticketSelected);
            JOptionPane.showMessageDialog(null, "Cruise ID: " + cruiseID + " contains " + ticketSelected + " Tickets");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error! Please enter a valid number of tickets.");
        }
    }

    public static void displayAllCruise(cruise[] allCruise) {
        int totalEarning = 0;
        int currentNumOfCruise = cruise.getCurrentNumOfCruise();
        String output = "** Patriot Cruises **\n\n\nCruise ID | Cruise Route | Ticket Cost | Ticket sold | Total Earning\n";
        for (int i = 0; i < currentNumOfCruise; i++) {
            if (allCruise[i] != null) {
                totalEarning += allCruise[i].getTicketPrice();
                output += allCruise[i].toString() + "\n";
            }
        }

        output += "\n" + "Total Cruise: " + cruise.getCurrentNumOfCruise() + "\n";
        output += "Total Earning: " + "$" + (totalEarning);
        JOptionPane.showMessageDialog(null, output);
    }

}
