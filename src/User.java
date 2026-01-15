import java.util.Objects;

public class User {
    private final String name;
    private int age;
    private static int userCounter = 0;
    public static final int MAX_AGE = 50;


    public User(String name, int age) {
        validate(name, age);
        this.name = name;
        this.age = age;
        userCounter ++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age >= MAX_AGE)
            throw new IllegalArgumentException("Age must be between 0 and " + (MAX_AGE - 1));
        this.age = age;
    }

    public static int getUserCounter() {
        return userCounter;
    }

    @Override
    public String toString() {
        return "\nUser :" +
                "\nName --- " + name +
                "\nAge --- " + age +
                "\n---------------";
    }
    private void validate (String name,int age){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        if (age < 0 || age >= MAX_AGE) throw new IllegalArgumentException("Age must be between 0 and " + (MAX_AGE - 1));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
