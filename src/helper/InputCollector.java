package helper;

import helper.Helper;

import java.util.Scanner;

public class InputCollector {
    public static String inputForPrompt(String promptString) {
        System.out.print("" + promptString);
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        return command;
    }
}
