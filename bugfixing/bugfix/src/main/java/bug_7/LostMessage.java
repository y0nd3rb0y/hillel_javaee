package bug_7;


/**
 * I want to see VeryImportant Exception as result:
 */

public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    static Exception exception = null;

    public static void main(String[] args) throws Exception {
        LostMessage lm = new LostMessage();
        try {
            lm.f();
        } catch(VeryImportantException vie) {
            exception = vie;
            //System.out.println(vie.toString());
        }

        finally {
            if(exception != null){
                throw exception;
            }
            lm.dispose();
        }

    }


}

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

