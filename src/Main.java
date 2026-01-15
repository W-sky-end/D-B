import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int count = 1;
            System.out.println("Enter age for persons!");
            List<User> users = new ArrayList<>();

            System.out.print("Enter age for " + count++ + " person: ");
            User vadim = new User("Vadim", sc.nextInt());

            System.out.print("Enter age for " + count++ + " person: ");
            User mia = new User("Mia", sc.nextInt());

            System.out.println("Enter age for " + count++ + " person: ");
            User mia2 = new User("Mia", sc.nextInt());
            users.add(vadim);
            users.add(mia);
            users.add(mia2);
            users.add(vadim);
            System.out.println("Users : " + users);

            Set<User> uniqueUsers = new HashSet<>(users);
            System.out.println("Unique users : " + uniqueUsers);

            Map<String,User> userMap = new HashMap<>();
            userMap.put("Vadim",vadim);
            userMap.put("Mia",mia);
            userMap.put("Mia2",mia2);
            userMap.put("Vadim2",vadim);

            System.out.println("Users : " + userMap);



            System.out.println(vadim + "\n" + mia + "\n" + mia2);
            System.out.println("Users create : " + User.getUserCounter());
            System.out.println("Set size: " + users.size());
            System.out.println(users);




        } catch (InputMismatchException e) {
            System.out.println("Age must be a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Can not create user: " + e.getMessage());
        }
    }
}
