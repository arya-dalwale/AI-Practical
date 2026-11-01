import java.util.Scanner;

public class NumberGuessAgent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int guess;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Give feedback: H = Higher, L = Lower, C = Correct");

        while (low <= high) {

            guess = (low + high) / 2;

            System.out.println("Agent guesses: " + guess);
            System.out.print("Feedback: ");

            char feedback = sc.next().toUpperCase().charAt(0);

            if (feedback == 'C') {
                System.out.println("Agent found the number!");
                break;
            }

            else if (feedback == 'H') {
                low = guess + 1;
            }

            else if (feedback == 'L') {
                high = guess - 1;
            }

            else {
                System.out.println("Invalid feedback!");
            }
        }

        sc.close();
    }
}