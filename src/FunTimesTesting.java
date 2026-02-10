import java.util.Scanner;

public class FunTimesTesting
    {
        static void main() {
            Scanner sc = new Scanner(System.in);

            System.out.println("worbles? yes or no? HAHAHAHA boompas");
            String worbles = sc.nextLine();

            if (worbles.toLowerCase().contains("yes")) {
                System.out.println("worbley!");
            } else {
                System.out.println("nup.");
            }
        }
}
