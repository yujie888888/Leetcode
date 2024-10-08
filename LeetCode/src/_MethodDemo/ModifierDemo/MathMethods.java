package _MethodDemo.ModifierDemo;

public class MathMethods {
    public static void main(String[] args) {
        // returns a random number between 0.0 (inclusive), and 1.0 (exclusive):
        double r1 = Math.random(); //[0.0, 1.0)
        System.out.println ((int)(r1*101)); //[0, 101)

        // Math.abs()

        // Math.max()

        // Math.min()

        // Math.sqrt() returns the square root of x
        System.out.println(Math.sqrt(5));

        // Math.pow(x,y) returns the x^y
        System.out.println(Math.pow(2,4));

    }
}
