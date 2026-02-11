import java.util.*;
import java.util.stream.Collectors;

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

            User guest = new User("Guest", 0);
            users.add(vadim);
            users.add(mia);
            users.add(mia2);
            users.add(vadim);
            users.add(guest);
            System.out.println("Users : " + users);



            List<User> sorted =
                    users.stream()
                            .sorted(
                                    Comparator.comparing(User::getName)
                                            .thenComparing(Comparator.comparingInt(User::getAge).reversed())
                            )
                            .toList();

            Optional<User> min =
                    users.stream().min(Comparator.comparingInt(User::getAge));

            TreeSet<User> set =
                    new TreeSet<>(Comparator.comparingInt(User::getAge)
                            .thenComparing(User::getName));



        } catch (IllegalArgumentException e) {
            System.out.println("Can not create user: " + e.getMessage());
        }

    }
}
