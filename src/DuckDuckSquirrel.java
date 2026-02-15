import java.util.Scanner;

//Javadoc Here
public class DuckDuckSquirrel {

    private final static String WELCOME_MESSAGE = "Another semester another issue... " +
            "Guess we better find those squirrels!";
    private final static String ENTRY_PROMPT = "Enter the String to Search:";
    private final static String SHUT_DOWN = "Hopefully that's all of them... Thanks for the help!";
    private final static String SEG_FAULT = "You know the term BUG comes from a literal bug " +
            "that got into a computer and caused an issue?\n" +
            "Maybe we should change it to ACORN... Alright lets try again...";
    private final static String LAZY_USER = "Typing issue? Come on, this won't fix itself.";

    //todo change this string to be correct
    private final static String VALID_OUTPUT_DIALOG = "Cycles: %f Ducks: %f Squirrels: %f DSR: %f.3 SCR: %f.3";

    //todo implement your program here

    static void main() {
        float ddsCount;
        float pureDuckCount;
        float squCount;
        float dsr;
        float scr;
        String input;
        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_MESSAGE);

        do {
            System.out.println(ENTRY_PROMPT);
            input = scan.nextLine();

            for(int i = 0; i >= input.length(); i++); {
                System.out.println(input.charAt(i + 2));
            }



        } while (!input.equals("exit"));

        System.out.println(SHUT_DOWN);






    }


}