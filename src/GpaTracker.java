import java.util.Scanner;

//Javadoc Here

public class GpaTracker {

    public static final String WELCOME_MESSAGE = "Welcome to the GPA Tracker!";
    public static final String MAIN_MENU = "Please Select an Operation\n" + "1 - Single Course\n" +
            "2 - Semester Results\n" + "3 - Exit";

    public static final String SINGLE_COURSE_PROMPT = "Please Enter Current GPA, Current Credits, Course Code, " +
            "Letter Grade, and Course Credits in the following format:";
    public static final String SEMESTER_PROMPT = "Please Enter the Semester String to be Calculated.";
    public static final String SINGLE_COURSE_OUTCOME = "The Result of the Single Course is";
    public static final String SEMESTER_OUTCOME = "The Final Semester Results are";
    public static final String CONFIRMATION = "Are You Sure You Want to Exit?";
    public static final String INVALID_INPUT = "Invalid Input! Try again";
    public static final String THANK_YOU = "Thank You For Using the GPA Tracker!";

    public static void main(String[] args) {
        boolean exitFlag = false;
        boolean falseExit = false;
        String initInput;
        String userInput;

        Scanner scan = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);

        do {
            System.out.println(MAIN_MENU);
            initInput = scan.nextLine();


            if (initInput.equals("1") || initInput.equals("2") || initInput.equals("3")) {
                switch (initInput) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        do {
                            System.out.println(CONFIRMATION);
                            falseExit = false;
                            userInput = scan.nextLine();

                            if (userInput.equals("yes") || userInput.equals("y")) {
                                System.out.println(THANK_YOU);
                                exitFlag = true;
                                break;
                            } else if (userInput.equals("no") || userInput.equals("n")) {
                                falseExit = true;
                            } else {
                                System.out.println(INVALID_INPUT);
                            }
                        } while (!falseExit);
                        break;
                }

            } else
                System.out.println(INVALID_INPUT);

        } while (!exitFlag);
    }
}
