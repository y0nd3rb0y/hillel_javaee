package bug_5;

public class ArrayOutOfBoundExceptionTest {

    public static void main(String args[]) {
        int ram[] = {1, 2, 3, 4, 5};
        changeArray(ram);
        for (int y : ram) System.out.println(y);

    }

    public static void changeArray(int x[]) {
        for (int count = 0; count < x.length; ) {
            x[count] += 5;
            count++;
        }

        for (int j : x) {
            System.out.println(x[j-5-1]);
            //System.out.println(x[j]);
        }
    }

}
