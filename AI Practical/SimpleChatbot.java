import java.util.Scanner;

public class SimpleChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chatbot: Hello! I am a simple chatbot.");
        System.out.println("Chatbot: Type 'bye' to exit.");

        while (true) {

            System.out.print("You: ");
            String input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hello! How are you?");
            }

            else if (input.contains("how are you")) {
                System.out.println("Bot: I am fine. Thank you!");
            }

            else if (input.contains("name")) {
                System.out.println("Bot: My name is SimpleBot.");
            }

            else if (input.contains("college")) {
                System.out.println("Bot: I can help you with college-related questions.");
            }

            else if (input.contains("thank")) {
                System.out.println("Bot: You are welcome!");
            }

            else if (input.contains("bye")) {
                System.out.println("Bot: Goodbye! Have a nice day.");
                break;
            }

            else {
                System.out.println("Bot: Sorry, I don't understand.");
            }
        }

        sc.close();
    }
}