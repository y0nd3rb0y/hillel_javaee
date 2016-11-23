package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User {
    private String name;
    private int age;



    private Map<Role, List<String>> roleTable = new HashMap<Role, List<String>>(){{
        put(Role.USER, Arrays.asList("sync", "submit"));
        put(Role.ADMIN, Arrays.asList("delete", "restore", "administer"));
        put(Role.SUPERUSER, Arrays.asList("purge", "stop", "start"));
    }};

    @UserRoleAnnotation
    private Role role;

/*    public User(String name, int age, Role role) {
        this.name = name;
        this.age = age;
    }*/

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +

                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getPermission() {
        StringBuilder sb = new StringBuilder();
        for(String s : roleTable.get(this.getRole())){
            sb.append(s).append(' ');
        }
        return "user " + this.getName() + " has permission " + sb.toString();
    }


}
