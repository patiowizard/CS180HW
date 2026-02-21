import java.util.Scanner;

public class studySource {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] foods;
        int size;

        System.out.print("Enter size of food list: ");
        size = scan.nextInt();
        scan.nextLine();

        foods = new String[size];

        for(int i = 0; i < foods.length; i++) {
            System.out.print("Enter a food: ");
            foods[i] = scan.nextLine();
        }

        for(String food : foods) {
            System.out.println(food);
        }



    }
}
