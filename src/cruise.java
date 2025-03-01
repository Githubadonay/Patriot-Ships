public class cruise {
    private String cruiseID;
    private String route;
    private double ticketPrice;
    private int ticketSold;
    public static int currentNumOfPassengers;

    // public static int

    cruise() {
        this.cruiseID = "";
        this.route = "";
        this.ticketPrice = 0;
        this.ticketSold = 0;
        currentNumOfPassengers++;
    };

    cruise(String cruiseID, String route, double ticketPrice, int ticketSold) {
        this.cruiseID = cruiseID;
        this.route = route;
        this.ticketPrice = ticketPrice;
        this.ticketSold = ticketSold;
        currentNumOfPassengers++;
    }

    // get
    public String getCuiseID() {
        return this.cruiseID;
    }

    public String getRoute() {
        return this.route;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public static int getCurrentNumOfPassengers() {
        return currentNumOfPassengers;
    }

    // set
    public void setCruiseID(String cruiseID) {
        if (!cruiseID.equals(""))
            this.cruiseID = cruiseID;
    }

    public void setRoute(String route) {
        if (!route.equals(""))
            this.route = route;
    }

    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice > 0) {
            this.ticketPrice = ticketPrice;
        }
    }

    public void setTicketSold(int ticketSold) {
        if (ticketSold > 0) {
            this.ticketSold = ticketSold;
        }
    }

    public void setCurrentNumOfPassengers(int currentNumOfPassengers) {
        currentNumOfPassengers--;
    }

    // calculation for the earing of ticker sold. ticketCost * ticketSold
    public double totalEarning() {
        return ticketPrice * ticketSold;
    }

    // toString
    public String toString() {
        return "Cruise ID | Cruise Route | Ticket Cost | Ticket sold | Total Earning\n"
                + getCuiseID() + getRoute() + getTicketPrice() + getTicketSold() + totalEarning() + "\n";
    };

}
