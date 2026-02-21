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
        int indexPos = 0;

        //single course variables
        double currentGPA;
        double currentCreds;
        String courseCode;
        String letterGrade;
        double courseCreds;
        double newCourseGPA;
        double gradePts;

        //semester variables
        String gpaProg;
        double startGPA;
        double startCreds;

        String initInput;
        String userInput;

        Scanner scan = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);

        do {
            //init input scanner position
            indexPos = 0;

            //init single course variables
            currentGPA = 0;
            currentCreds = 0;
            courseCode = "";
            letterGrade = "";
            courseCreds = 0;
            newCourseGPA = 0;
            gpaProg = "";
            gradePts = 0;

            //welcome
            System.out.println(MAIN_MENU);
            initInput = scan.nextLine();

            //menu system
            if (initInput.equals("1") || initInput.equals("2") || initInput.equals("3")) {
                switch (initInput) {
                    //Single Course
                    case "1":
                        System.out.println(SINGLE_COURSE_PROMPT);
                        userInput = scan.nextLine();

                        //parse data from userInput
                        currentGPA = Double.parseDouble(userInput.substring
                                (indexPos, userInput.indexOf("-", indexPos)));
                        indexPos = userInput.indexOf("-", indexPos);

                        currentCreds = Double.parseDouble(userInput.substring
                                (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                        indexPos = userInput.indexOf("-", indexPos + 1);

                        courseCode = (userInput.substring
                                (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                        indexPos = userInput.indexOf("-", indexPos + 1);

                        letterGrade = (userInput.substring
                                (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                        indexPos = userInput.indexOf("-", indexPos + 1);

                        if ((userInput.charAt(indexPos + 1)) == '-') {
                            letterGrade += "-";
                            indexPos += 1;
                        }

                        courseCreds = Double.parseDouble(userInput.substring
                                (indexPos + 1));

                        //calc gradePts
                        gradePts = switch (letterGrade) { //calc gradePts
                            case "A" -> 4.0;
                            case "A-" -> 3.7;
                            case "B+" -> 3.3;
                            case "B" -> 3.0;
                            case "B-" -> 2.7;
                            case "C+" -> 2.3;
                            case "C" -> 2.0;
                            case "C-" -> 1.7;
                            case "D+" -> 1.3;
                            case "D" -> 1.0;
                            case "D-" -> 0.7;
                            case "F" -> 0;
                            default -> gradePts;
                        };

                        //calc newCourseGPA
                        newCourseGPA = ((currentGPA * currentCreds) + //calc current TQP and add...
                                (gradePts * courseCreds)) / //calc new course TQP
                                        (currentCreds + courseCreds); //calc TC

                        //print final message
                        System.out.printf(SINGLE_COURSE_OUTCOME + " %.2f\n", newCourseGPA);
                        break;
                    //Semester Results
                    case "2":
                        System.out.println(SEMESTER_PROMPT);
                        userInput = scan.nextLine();

                        //parse current data from userInput
                        currentGPA = Double.parseDouble(userInput.substring
                                (indexPos, userInput.indexOf("-", indexPos)));
                        indexPos = userInput.indexOf("-", indexPos);

                        currentCreds = Double.parseDouble(userInput.substring
                                (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                        indexPos = userInput.indexOf("-", indexPos + 1);

                        //on the fly calc the following course triples, concatting gpaProg with result
                        while (userInput.indexOf("-", indexPos + 1) != -1) { //parse data from each course
                            //init vars used in loop (?)
                            courseCode = (userInput.substring
                                    (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                            indexPos = userInput.indexOf("-", indexPos + 1);

                            letterGrade = (userInput.substring
                                    (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                            indexPos = userInput.indexOf("-", indexPos + 1);

                            if ((userInput.charAt(indexPos + 1)) == '-') {
                                letterGrade += "-";
                                indexPos += 1;
                            }

                            if (userInput.indexOf("-", indexPos + 1) != -1) {
                                courseCreds = Double.parseDouble(userInput.substring
                                        (indexPos + 1, userInput.indexOf("-", indexPos + 1)));
                                indexPos = userInput.indexOf("-", indexPos + 1);
                            } else {
                                courseCreds = Double.parseDouble(userInput.substring(indexPos + 1));
                            }

                            //calc gradePts
                            gradePts = switch (letterGrade) { //calc gradePts
                                case "A" -> 4.0;
                                case "A-" -> 3.7;
                                case "B+" -> 3.3;
                                case "B" -> 3.0;
                                case "B-" -> 2.7;
                                case "C+" -> 2.3;
                                case "C" -> 2.0;
                                case "C-" -> 1.7;
                                case "D+" -> 1.3;
                                case "D" -> 1.0;
                                case "D-" -> 0.7;
                                case "F" -> 0;
                                default -> gradePts;
                            };

                            //make gpa calcs at this point and concat to gpaProg
                            currentGPA = ((currentGPA * currentCreds) + //calc current TQP and add...
                                    (gradePts * courseCreds)) / //calc new course TQP
                                    (currentCreds + courseCreds); //calc TC
                            currentCreds = (currentCreds + courseCreds);

                            gpaProg += "-" + String.format("%.2f", currentGPA);
                        }

                        //final print
                        System.out.printf(SEMESTER_OUTCOME + " %.2f%s\n", currentGPA, gpaProg);
                        break;
                    //Exit
                    case "3":
                        do {
                            System.out.println(CONFIRMATION);
                            falseExit = false;
                            userInput = scan.nextLine();

                            if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
                                System.out.println(THANK_YOU);
                                exitFlag = true;
                                break;
                            } else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n")) {
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
