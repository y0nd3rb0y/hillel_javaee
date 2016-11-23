package reflection;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class UserSystemManager {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("xxx", 12);
        Class<? extends User> userClass = user.getClass();
        System.out.println("Class name = " + userClass.getName());

        /*Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            printModifiersById(constructor.getModifiers());

            System.out.println(Arrays.toString(constructor.getGenericParameterTypes()));
        }
        //userClass.newInstance();
        Field[] fields = userClass.getDeclaredFields();
        for(Field field : fields){
            printModifiersById(field.getModifiers());
            System.out.println(field.getModifiers());
            System.out.println(field.getName());
        }

        System.out.println(user);
        Field fieldName = userClass.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(user, "yyy");
        System.out.println(user);*/

        String test = "test";
        System.out.println("str value = " + test + " hc: " + test.hashCode());
        test = test.concat("xyz");
        System.out.println("str value = " + test + " hc: " + test.hashCode());
        //case with reflection;

        test = "test";
        System.out.println("str value = " + test + " hc: " + test.hashCode());
        Field value = test.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(test, "test_xxx".toCharArray());
        printModifiersById(value.getModifiers());
        System.out.println("str value = " + test + " hc: " + test.hashCode());

        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object o = theUnsafe.get(null);

        //if(o instanceof Unsafe){
            Unsafe unsafe = (Unsafe) o;

        //}

        //woo hoo
        //unsafe.throwException(new IOException("asdfasdfadsf"));
        /*throw new IOException();*/


        Method[] methods = userClass.getMethods();
        for(Method method : methods){
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            Annotation[] annotations = declaredAnnotations;
            for(Annotation annotation : annotations){
                UserAnnotation userAnnotation = method.getAnnotation(UserAnnotation.class);
                if(userAnnotation != null){
                    System.out.println(userAnnotation.companyName());
                }
                System.out.println("Annotation type  - " + annotation.annotationType().getName());

            }
        }

    }

    private static void printModifiersById(int modifier){
        if(Modifier.isPublic(modifier)){
            System.out.println("public");
        }
        if(Modifier.isFinal(modifier)){
            System.out.println("final");
        }
        if(Modifier.isPrivate(modifier)){
            System.out.println("private");
        }

    }
}
