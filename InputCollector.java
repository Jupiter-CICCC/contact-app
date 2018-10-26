package Contact_list;

public class InputCollector {

    private String promptString;
    private String fullname;
    private String email;

    InputCollector() {

    }

    public String getPromptString() {
        return this.promptString;
    }

    public String inputForPrompt(String input) {
        this.promptString = input;
        return getPromptString();
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getEmail() {
        return this.email;
    }


}
