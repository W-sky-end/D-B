import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter age for first and second persons:");

            System.out.print("Enter age for 1st person: ");
            User vadim = new User("Vadim", sc.nextInt());

            System.out.print("Enter age for 2nd person: ");
            User mia = new User("Mia", sc.nextInt());

            System.out.println(vadim + "\n" + mia);

        } catch (InputMismatchException e) {
            System.out.println("Age must be a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Can not create user: " + e.getMessage());
        }
    }
}
