package contact;

public class Phone {
    private String label;
    private String phone;
    public Phone(String label, String phone) {
        this.label = label;
        this.phone = phone;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
