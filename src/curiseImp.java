import javax.swing.JOptionPane;

public class curiseImp {
    public static void main(String[] args) {
        final int maxNumOfPassenger = 300;
        final int maxNumOfCruise = 10;
        // public static int NumOfCruise = 10;

        cruise[] allCruise = new cruise[maxNumOfCruise];// setting the array for cruise
        int choice = 0;
        // menu using do-while and switch case
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "Choose one of the following option: \n1. Create Cruise \n2. Search Cruise \n3. Remove Cruise \n4. Sell Cruise Ticket \n5. Display All Cruise \n6. Exit \n Enter your choice"));
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

                default:
                    break;
            }
        } while (choice >= 1 && choice <= 6);
        JOptionPane.showMessageDialog(null, choice);
    }

    
}
