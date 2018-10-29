package helper;

import contact.Contact;

public class DuplicateContactException extends Exception {
    private Contact oldContact;
    private Contact newContact;

    public DuplicateContactException(Contact savedContact, Contact newContact) {
        this.oldContact = savedContact;
        this.newContact = newContact;
    }

    public Contact getOldContact() {
        return oldContact;
    }

    public Contact getNewContact() {
        return newContact;
    }
}
