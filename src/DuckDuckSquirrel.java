import java.util.Scanner;

/**
 * DuckDuckSquirrel Program - HW05 Challenge
 *
 * This program takes input from the user on a loop, and each time parses through
 * the data and calculates various counts asked by the assignment such as how many
 * times the word "duck" or "squirrel" appear. The user is then presented with a
 * formatted, printed statement returning this information to them
 *
 * @author Andres Maldonado, Lab Section L18
 *
 * @version February 16, 2026
 *
 */
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
    private final static String VALID_OUTPUT_DIALOG = "Cycles: %.0f Ducks: %.0f Squirrels: %.0f DSR: %.3f SCR: %.3f\n";

    //todo implement your program here
    public static void main(String[] args) {

        String sgf = "segfault";
        int sgfSuccess = 0;
        boolean sgfFail = false;

        String dds = "duckducksquirrel";
        float ddsCount = 0;
        int ddsSuccess = 0;

        String squ = "squirrel";
        float squCount = 0;
        int squSuccess = 0;

        String dk = "duck";
        float dkCount = 0;
        int pos = 0;



        float dsr = 0;
        float scr = 0;

        boolean exitFlag = false;
        String input;




        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_MESSAGE);


        // main loop, leaves if exitFlag is triggered
        do {
            // initialize variables, so blank slate every time
            sgfFail = false;
            sgfSuccess = 0;

            ddsCount = 0;
            ddsSuccess = 0;

            dkCount = 0;
            pos = 0;

            squCount = 0;
            squSuccess = 0;


            dsr = 0;
            scr = 0;

            System.out.println(ENTRY_PROMPT);
            input = scan.nextLine();

            if (!input.equals("exit")) {

                //checks for segfault
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == sgf.charAt(sgfSuccess)) {
                        sgfSuccess++;
                    }
                    if (sgfSuccess == sgf.length()) {
                        System.out.println(SEG_FAULT);
                        sgfFail = true;
                        break;
                    }
                }
                if (sgfFail) {
                    continue;
                }

                //checks for # of dds cycles
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == dds.charAt(ddsSuccess)) {
                        ddsSuccess++;
                    }
                    if (ddsSuccess == dds.length()) {
                        ddsCount++;
                        ddsSuccess = 0;
                    }
                }

                //checks for # of contiguous, or pure, ducks
                if (input.contains(dk)) {
                    while ((pos = input.indexOf(dk, pos)) != -1) {
                        dkCount++;
                        pos += 4;
                    }
                }

                //checks for # of squirrels
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == squ.charAt(squSuccess)) {
                        squSuccess++;
                    }
                    if (squSuccess == squ.length()) {
                        squCount++;
                        squSuccess = 0;
                    }
                }

                if (squCount != 0 && ddsCount != 0) {
                    dsr = dkCount / squCount;
                    scr = squCount / ddsCount;
                    System.out.printf(VALID_OUTPUT_DIALOG, ddsCount, dkCount, squCount, dsr, scr);
                } else if (ddsCount + dkCount + squCount != 0) {
                    System.out.println(SEG_FAULT);
                } else {
                    System.out.println(LAZY_USER);
                }


            } else {
                exitFlag = true;
            }

        } while (!exitFlag);

        System.out.println(SHUT_DOWN);






    }


}