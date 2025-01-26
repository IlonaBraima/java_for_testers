import java.io.File;

public class Hello {

    public static void main(String[] args) {
        try {
           int z = calculate();
            System.out.println("Hello, world!");
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
        }
    }

    private static int calculate() {
        var x = 1;
        var y = 0;
        var z = devide(x, y);
        return z;
    }

    private static int devide(int x, int y) {
        var z = x / y;
        return z;
    }
}
