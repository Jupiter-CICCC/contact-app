package Contact_list;

import java.util.ArrayList;

public class ContactList {
    ArrayList<Contact> contactLists = new ArrayList<Contact>();

    ContactList() {
    }

    public void addContact(Contact newContact) {
        contactLists.add(newContact);
    }
}
