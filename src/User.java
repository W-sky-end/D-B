public class User {
    private final String name;
    private int age;


    public User(String name, int age) {
        validate(name, age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    @Override
    public String toString() {
        return "User :" +
                "\nName --- " + name +
                "\nAge --- " + age +
                "\n---------------";
    }
    private void validate (String name,int age){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
    }

}
