package bug_2;

public class NullPointerExceptionBug_1 {
    static String msg;

    public static void main(String[] args) {

        System.out.println(Test.handle(new Formatter(), msg));
    }
}

class Formatter {
    public String format(String value) {
        return "[" + value + "]";
    }
}

class Test {
    public static String handle(Formatter f, String s) {
        if (s == null || s.isEmpty()) {
            return "(none)";
        }
        return f.format(s.trim());
    }
}