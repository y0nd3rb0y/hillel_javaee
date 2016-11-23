package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Map<String, Role> userMap = readExistingUserBase();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Enter username: ");
            if(scanner.hasNext()) {
                String name = scanner.next();
                User user = new User(name, 20);
                if (userMap.containsKey(name)) {
                    user.setRole(userMap.get(name));
                } else {
                    Field roleField = user.getClass().getDeclaredField("role");
                    UserRoleAnnotation roleAnnotation = roleField.getDeclaredAnnotation(UserRoleAnnotation.class);
                    if(roleAnnotation!=null) {
                        user.setRole(roleAnnotation.role);
                    }
                }
                System.out.println(user.getPermission());
            }
        }
    }
    private static Map<String, Role> readExistingUserBase() {
        Map<String, Role> map = new HashMap<String, Role>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("table.txt"));
            String line = "";

            while ((line = in.readLine()) != null) {
                String part[] = line.split(":");
                if("ADMIN".equals(part[1])){
                    map.put(part[0], Role.ADMIN);
                } else if ("SUPERUSER".equals(part[1])){
                    map.put(part[0], Role.SUPERUSER);
                }

            }
            in.close();
        } catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return map;
    }
}
