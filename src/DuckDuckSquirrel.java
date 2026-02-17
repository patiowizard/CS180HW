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
    private final static String VALID_OUTPUT_DIALOG = "Cycles: %.0f Ducks: %.0f Squirrels: %.0f DSR: %.3f SCR: %.3f\n";

    //todo implement your program here

    static void main() {

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
        int dkSuccess = 0;
        String dkCheckerString = "";

        float dsr = 0;
        float scr = 0;

        boolean exitFlag = false;
        String input;




        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_MESSAGE);


        // main loop, leaves if exitFlag is triggered
        do {
            // initialize variables, so blank slate every time
            sgfSuccess = 0;

            ddsCount = 0;
            ddsSuccess = 0;

            dkCount = 0;
            dkSuccess = 0;
            dkCheckerString = "";

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
                    if (sgfSuccess == sgf.length() - 1) {
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
                    if (ddsSuccess == dds.length() - 1) {
                        ddsCount++;
                        ddsSuccess = 0;
                    }
                }

                //checks for # of contiguous, or pure, ducks
                if (input.contains(dk)) {
                    dkCheckerString = input;
                    while (dkCheckerString.contains(dk)) {
                        int startDk = dkCheckerString.indexOf("d");
                        int endDk = dkCheckerString.indexOf("k") + 1;

                        if (dkCheckerString.substring(startDk, endDk).equals(dk)) {
                            dkCount++;
                        }

                        dkCheckerString = dkCheckerString.substring(endDk, dkCheckerString.length());
                    }
                }

                //checks for # of squirrels
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == squ.charAt(squSuccess)) {
                        squSuccess++;
                    }
                    if (squSuccess == squ.length() - 1) {
                        squCount++;
                        squSuccess = 0;
                    }
                }

                if (squCount != 0 && ddsCount != 0) {
                    dsr = dkCount / squCount;
                    scr = squCount / ddsCount;
                    System.out.printf(VALID_OUTPUT_DIALOG, ddsCount, dkCount, squCount, dsr, scr);
                } else if (ddsCount + dkCount + squCount != 0){
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