package Contact_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

        // Task2
        if (input.equals("quit")) {
            System.exit(0);
        }

        // Task3
        if (input.equals("new")) {
            System.out.println("Enter your fullname");
            Scanner inputFullname = new Scanner(System.in);
            String username = inputFullname.nextLine();
            String name = collector.inputForPrompt(username);

            System.out.println("Enter your email");
            Scanner inputEmail = new Scanner(System.in);
            String useremail = inputEmail.nextLine();
            String email = collector.inputForPrompt(useremail);

            Contact contact = new Contact(name, email);
            ContactList contactList = new ContactList();
            contactList.addContact(contact);
        }

    }
}
