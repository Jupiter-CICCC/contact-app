import contact.Contact;
import contact.ContactList;
import helper.DuplicateContactException;
import helper.Helper;
import helper.InputCollector;
import helper.LogRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Driver {
    public static String main() {
        Helper.clearScreen();
        System.out.println("What would you like to do next?");
        System.out.println("New - Create a new contact");
        System.out.println("List - List all contacts");
        System.out.println("find - Search for some contact");
        System.out.println("log - Show log");
        System.out.println("Quit - Exit Application");

        String option = InputCollector.inputForPrompt("option: ");
        return option;
    }

    // Controllers ------------
    public static void newContact() {
        Helper.clearScreen();
        String email = InputCollector.inputForPrompt("Email: ");
        Contact contact = ContactList.findByEmail(email);
        if(contact == null) {
            String firstName = InputCollector.inputForPrompt("First Name: ");
            String lastName = InputCollector.inputForPrompt("Last Name: ");
            contact = new Contact(email, firstName, lastName);
            contact.promptForPhone();
            try {
                ContactList.addContact(contact);
            } catch (DuplicateContactException e) {
                System.err.println("this contact already exist!");
            }
        }
        LogRegistry.register(  "new contact: " + contact.getEmail());
        show(contact.getId());
    }
    public static void listContacts() {
        LogRegistry.register(  "list all users.");
        listContacts(ContactList.findAll());
    }
    public static void listContacts(ArrayList<Contact> contactList) {
        Helper.clearScreen();
        if(contactList.size() == 0) {
            System.err.println("no result");
            String command = InputCollector.inputForPrompt("\npress 'enter' to go back. ");
        } else {
            System.out.println(ContactList.printableContactList(contactList));
            System.out.println("\nType the 'id' to show more details or 'enter' to go back: ");
            String command = InputCollector.inputForPrompt("id: ");
            if(command.equalsIgnoreCase("back")) {
                return;
            } else {
                try {
                    int id = Integer.parseInt(command);
                    show(id);
                } catch (NumberFormatException err) {
                }
            }
        }
    }
    public static void show(int id) {
        Helper.clearScreen();
        Contact contact = ContactList.findById(id);
        LogRegistry.register(  "show contact #" + id);
        if(contact != null) {
            System.out.println(ContactList.printableContact(contact));
        } else {
            System.err.println("Invalid ID!");
            System.out.println("Press any key to continue.");
            InputCollector.inputForPrompt("");
            listContacts();
        }
        System.out.println("\nType 'add' to add new phone number or 'enter' to go back:");
        String command = InputCollector.inputForPrompt("");
        if(command.equalsIgnoreCase("add")) {
            contact.promptForPhone();
            show(id);
        } else {
            listContacts();
        }
    }
    public static void find() {
        Helper.clearScreen();
        String search = InputCollector.inputForPrompt("Search: ");
        ArrayList<Contact> results = ContactList.find(search);
        LogRegistry.register(  "search for: " + search);
        listContacts(results);
    }
    public static void log() {
        Helper.clearScreen();
        System.out.println("lastest actions: ");
        System.out.println(LogRegistry.printableLog());
        InputCollector.inputForPrompt("press enter to continue.");
    }


    // main ------------
    public static void main(String[] args) throws IOException {
        ContactList.generateDummyData();
        String chosenOption = null;
        while (chosenOption == null || !chosenOption.equalsIgnoreCase("quit")) {
            chosenOption = main();
            System.out.println("\r");
            if(chosenOption.equalsIgnoreCase("new")) {
                newContact();
            } else if(chosenOption.equalsIgnoreCase("list")) {
                listContacts();
            } else if(chosenOption.equalsIgnoreCase("find")) {
                find();
            } else if(chosenOption.equalsIgnoreCase("log")) {
                log();
            }
        }
        Helper.clearScreen();
        System.err.println("Bye bye!");
    }
}
