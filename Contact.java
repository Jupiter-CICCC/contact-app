package Contact_list;

public class Contact {
    private String fullname;
    private String email;

    Contact(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getEmail() {
        return this.email;
    }
}
