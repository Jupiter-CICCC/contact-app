package Contact_list;

public class InputCollector {
    private String promptString;

    InputCollector() {
    }

    public String getPromptString() {
        return this.promptString;
    }

    public String inputForPrompt(String input) {
        this.promptString = input;
        return getPromptString();
    }
}
