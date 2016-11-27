package bugs.bug_2_cast_exception;

import java.io.IOException;

public class ClassCastExceptionBug {

    public static void main(String[] args) throws IOException {
        A a = new B(); //upcasting to superclass
        B b = (B) a; //downcasting to subclass which is type of B for sure.
        //B b = (B) new A(); //incorrect downcasting to class

        System.out.println(b.a);
    }
}

class A {

    int a = 10;

    public void doSomethimg() {
        System.out.println("class A");
    }

}

class B extends A {

    int a = 20;

    @Override
    public void doSomethimg() {
        System.out.println("class B");
    }

}
