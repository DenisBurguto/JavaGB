package ExceptionHT2;

public class Task2 {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.err.println("Catching exception: " + e);
        }


    }
}
