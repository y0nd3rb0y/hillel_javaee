package bugs.bug_5_NullPointerException;

public class Printer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        if(name != null && !name.isEmpty()) {
            printString(name);
        } else {
            System.out.println("print method called with name unset");
        }
    }

    private void printString(String s) {
        System.out.println(s + " (" + s.length() + ")");
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
    }
}