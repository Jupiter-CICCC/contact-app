package contact;

import helper.DuplicateContactException;

import java.util.ArrayList;

public class ContactList {
    private static int lastId = -1;

    public static int generateId() {
        lastId = lastId + 1;
        return lastId;
    }

    private static ArrayList<Contact> contactList = new ArrayList<Contact>();
    public static void generateDummyData() {
        try {
            addContact(new Contact("derrick@ciccc.ca", "Derrick", "Park", new Phone("home", "(604) 666-1111")));
            addContact(new Contact("poli@ciccc.ca", "Poliana", "Schnornberger", new Phone("cellphone", "(604) 666-2222")));
            addContact(new Contact("ayana@ciccc.ca", "Ayana", "Sakai", new Phone("work", "(604) 666-4444")));
        } catch (DuplicateContactException e) {
            e.printStackTrace();
        }
    }

    public static void addContact(Contact newContact) throws DuplicateContactException {
        Contact created = findByEmail(newContact.getEmail());
        if (created != null) {
            throw new DuplicateContactException(created, newContact);
        }
        contactList.add(newContact);
    }

    public static boolean deleteById(int id) {
        return contactList.removeIf(contact -> (contact.getId() == id));
    }

    public static Contact findByEmail(String email) {
        for (Contact contact : contactList) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                return contact;
            }
        }
        return null;
    }

    public static ArrayList<Contact> findAll() {
        return contactList;
    }

    public static ArrayList<Contact> find(String search) {
        ArrayList<Contact> searchResult = new ArrayList<Contact>();
        for (Contact contact : contactList) {
            String fullname = contact.getFirstName() + " " + contact.getLastName();
            if (contact.getEmail().equalsIgnoreCase(search)) {
                searchResult.add(contact);
            } else if (fullname.toLowerCase().contains(search.toLowerCase())) {
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public static Contact findById(int id) {
        if (contactList.size() == 0) {
            return null;
        }
        int low = 0;
        int high = contactList.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (id > contactList.get(middle).getId()) {
                low = middle + 1;
            } else if (id < contactList.get(middle).getId()) {
                high = middle - 1;
            } else {
                return contactList.get(middle);
            }
        }
        return null;
    }

    public static String printableContact(Contact contact) {
        StringBuilder sb = new StringBuilder();
        sb.append(contact.printableInfo());
        return sb.toString();
    }

    public static String printableContactList(ArrayList<Contact> contactList) {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contactList) {
            sb.append("\n" + contact.printableShortInfo());
        }
        return sb.toString();
    }
}
