package reflection;

public class User {
    private String name;
    private int age;
    private final int sale = 100;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
/*
    public void setName(String name) {
        this.name = name;
    }*/

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printClientInfo(User user) {
        System.out.println("Client " + user.getName() + " has age " + user.getAge());
    }

    @Override
    @UserAnnotation
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
