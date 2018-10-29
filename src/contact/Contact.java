package contact;

import helper.Helper;
import helper.InputCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Contact {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private ArrayList<Phone> phoneList;

    public Contact() {
        this.phoneList = new ArrayList<Phone>();
        this.id = ContactList.generateId();
    }
    public Contact(String email, String firstName, String lastName) {
        this();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Contact(String email, String firstName, String lastName, Phone phone) {
        this(email, firstName, lastName);
        phoneList.add(phone);
    }
    public Contact(String email, String firstName, String lastName, Phone[] phoneList) {
        this(email, firstName, lastName);
        for (Phone phone: phoneList) {
            this.phoneList.add(phone);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void promptForPhone() {
        Helper.clearScreen();
        System.out.println("Add new phone number for:");
        System.out.println(this.printableShortInfo());
        String phoneLabel = InputCollector.inputForPrompt("\t label: ");
        String phoneNumber = InputCollector.inputForPrompt("\t phone: ");
        Phone phone = new Phone(phoneLabel, phoneNumber);
        this.phoneList.add(phone);
    }

    public String printableShortInfo() {
        return this.getId() + " : " + this.getFirstName() + " " + this.getLastName();
    }

    public String printableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: " + this.getId());
        sb.append("\nemail: " + this.getEmail());
        sb.append("\nname: " + this.getFirstName() + " " + this.getLastName());
        sb.append("\nPhones:");
        for (Phone phone: this.phoneList) {
            sb.append("\n - " + phone.getLabel() + " : " + phone.getPhone());
        }
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName);
    }
}
