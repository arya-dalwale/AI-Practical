import java.util.Scanner;

public class VacuumAgent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter location (A/B): ");
        char location = sc.next().toUpperCase().charAt(0);

        System.out.print("Enter status (Clean/Dirty): ");
        String status = sc.next();

        if (status.equalsIgnoreCase("Dirty")) {
            System.out.println("Action: SUCK");
            System.out.println("Room " + location + " is now Clean.");
        } 
        else {
            if (location == 'A') {
                System.out.println("Action: MOVE RIGHT");
            } 
            else {
                System.out.println("Action: MOVE LEFT");
            }
        }

        sc.close();
    }
}