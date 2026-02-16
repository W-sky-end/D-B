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

            List<User> young = users.stream().filter(u -> u.getAge() < 20).toList();
            boolean olderThanFifty = users.stream().anyMatch(u -> u.getAge() > 50);
            boolean youngerThatTen = users.stream().anyMatch(u -> u.getAge() > 10);

            List<String> names = users.stream().map(User::getName).toList();
            List<Integer> ages = users.stream().map(User::getAge).toList();
            List<String> info = users.stream().map(u -> "Имя: " + u.getName() + "Возраст: " + u.getAge()).toList();

            List<String> namesSecond = users.stream().filter(u -> u.getAge() > 25).map(User::getName).toList();
            List<String> uniqueNames = users.stream().map(User::getName).distinct().toList();
            Optional<User> first = users.stream().filter(u -> u.getAge() > 30).findFirst();
            double ave = users.stream().mapToInt(User::getAge).average().orElse(0);

            List<User> age = users.stream().sorted(Comparator.comparing(User::getAge).
                    reversed()).limit(3).toList();
            List<User> name = users.stream().sorted(Comparator.comparing(User::getName)
                    .reversed()).distinct().limit(3).toList();

            Optional<User> opt = Optional.of(users.stream()
                    .filter(u -> u.getName().equals("Alex")).findFirst().orElse(new User("Guest", 0)));
            Optional<User> opt2 = users.stream()
                    .filter(u -> u.getName().equals("Mia")).findFirst();
            opt2.ifPresent(System.out::println);
            String minAge = users.stream()
                    .min(Comparator.comparingInt(User::getAge))
                    .map(u -> u.getName() + ": " + u.getAge())
                    .orElse("Unknown");




        } catch (IllegalArgumentException e) {
            System.out.println("Can not create user: " + e.getMessage());
        }


    }
}
