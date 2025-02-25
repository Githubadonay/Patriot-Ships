public class cruise {
    private String cruiseID;
    private String route;
    private double ticketPrice;
    public static int maxNumOfCruise = 10;

   // public static int

cruise(){
    this.cruiseID = ""; 
    this.route = ""; 
    this.ticketPrice = 0; 
};
cruise(String cruiseID, String route, double ticketPrice){
    this.cruiseID = cruiseID;
    this.route = route;
    this.ticketPrice = ticketPrice;
}

// get
public String getCuiseID(){
    return this.cruiseID;
}
public String getRoute(){
    return this.route;
}
public double getTicketPrice(){
    return this.ticketPrice;
}

//set
public void setCruiseID(String cruiseID){
    if(!cruiseID.equals(""))
    this.cruiseID = cruiseID;
}

public void setRoute(String route){
    if(!route.equals(""))
    this.route = route;
}

public void setTicketPrice(double ticketPrice){
    if(ticketPrice > 0){
        this.ticketPrice = ticketPrice;
    }
}

// calculation 

//toString

}


