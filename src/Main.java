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

            Optional<User> maxAge ;
            maxAge = Optional.of(users.stream().max(Comparator.comparing(User::getAge)).orElseGet(()-> new User("No adult",0)));//вышло с костылем

            double average = users.stream().mapToInt(User::getAge).average().orElse(0);

            String minAge = users.stream().min(Comparator.comparing(User::getAge)).map(User::getName).orElse("Unknown");

            int maxAge2 = users.stream()
                    .sorted(Comparator.comparingInt(User::getAge).reversed())
                    .findFirst()
                    .map(User::getAge)
                    .orElse(0);



        } catch (IllegalArgumentException e) {
            System.out.println("Can not create user: " + e.getMessage());
        }


    }
}
