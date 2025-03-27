public class cruise {
    private String cruiseID;
    private String route;
    private int ticketPrice;
    private int ticketSold;
    public static int currentNumOfCruise;
    public static int maxNumOfPassenger = 300;

    // public static int

    cruise() {
        this.cruiseID = "";
        this.route = "";
        this.ticketPrice = 0;
        this.ticketSold = 0;
        currentNumOfCruise++;
        ticketSold++;
    };

    cruise(String cruiseID, String route, int ticketPrice, int ticketSold) {
        this.cruiseID = cruiseID;
        this.route = route;
        this.ticketPrice = ticketPrice;
        this.ticketSold = ticketSold;
        currentNumOfCruise++;
        ticketSold++;
    }

    // get
    public String getCruiseID() {
        return this.cruiseID;
    }

    public String getRoute() {
        return this.route;
    }

    public int getTicketPrice() {
        return this.ticketPrice;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public static int getCurrentNumOfCruise() {
        return currentNumOfCruise;
    }

    // set
    public void setCruiseID(String cruiseID) {
        if (cruiseID.length() == 5)
            this.cruiseID = cruiseID; 
            else
            throw new IllegalArgumentException("Cruise ID can not be empty, and Must be 5 Chararcters long ");
    }

    public void setRoute(String route) {
        if (!route.equals(""))
            this.route = route;
            else
            throw new IllegalArgumentException("Route can not be empty");
    }

    public void setTicketPrice(int ticketPrice) {
        if (ticketPrice > 0)
            this.ticketPrice = ticketPrice;
            else
            throw new IllegalArgumentException("Ticket price can not be empty");
    }

    public void setTicketSold(int ticketSold) {
        if (ticketSold > 0 && ticketSold < maxNumOfPassenger) 
            this.ticketSold = ticketSold;
            else
            throw new IllegalArgumentException("Ticket sold can not be empty");
            ticketSold--;
    }

    public static void updateNumOfCruise() {
        currentNumOfCruise--;
    }

    // calculation for the earing of ticker sold. ticketCost * ticketSold
    public int totalEarning() {
        return ticketPrice * ticketSold;
    }

    // toString
    public String toString() {
        return this.getCruiseID()  + " | " + this.getRoute()  + " | " + "$"+ this.getTicketPrice()   + " | " + this.getTicketSold()   + " | "+  "$"+ this.totalEarning();
    };

}
