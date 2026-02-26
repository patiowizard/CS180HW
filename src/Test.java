import java.util.Scanner;

public class Test {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        String input = readInput(s);
        System.out.println(input);
    }

    public static String readInput(Scanner s) {
        return s.nextLine();
    }
}
