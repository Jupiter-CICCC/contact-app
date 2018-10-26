package Contact_list;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        // Task1
        System.out.println("The menu:");
        System.out.println("What would you like to do next?");
        System.out.println("new - Create a new contact");
        System.out.println("list - List all contacts");
        System.out.println("quit - Exit Application");

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();

        InputCollector collector = new InputCollector();
        String input = collector.inputForPrompt(userInput);
        System.out.println("Your input is: " + input);

        // Task2
        if (input.equals("quit")) {
            System.exit(0);
        }

        // Task3
        if (input.equals("new")) {
            System.out.println("Enter your fullname");
            Scanner inputFullname = new Scanner(System.in);
            String username = inputFullname.nextLine();
            collector.setFullname(username);

            System.out.println("Enter your email");
            Scanner inputEmail = new Scanner(System.in);
            String useremail = inputEmail.nextLine();
            collector.setEmail(useremail);
        }

    }
}
