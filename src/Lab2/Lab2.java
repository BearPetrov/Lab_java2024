package Lab2;

public class Lab2 {
    public Lab2() {
    }

    public static Double solveFirstEquation(double a, double b, double c, double d) {
        double term1 = Math.pow(a, b) / Math.sinh(Math.abs(b));
        double term2 = 4.0 * Math.log(c) / Math.pow(d, 0.25);
        return term1 + term2;
    }

    public static Double solveSecondEquation(double a, double b, double c, double d) {
        double term1 = 2.0 * Math.log(Math.pow(b, a));
        double term2 = Math.abs(Math.asin(-Math.sqrt(d / c)));
        return term1 + term2;
    }

    public static Double solveThirdEquation(double a, double b, double c, double d) {
        double term1 = 3.0 * a / Math.cos(a);
        double term2 = Math.sqrt(Math.tanh(Math.abs(b) * c) / Math.log(d));
        return term1 + term2;
    }

    public static void main(String[] args) {
        System.out.println("Result of the first equation: " + solveFirstEquation(1.27, 10.99, 2.73, 25.32));
        System.out.println("Result of the second equation: " + solveSecondEquation(3.56, 1.02, 3.0, 2.43));
        System.out.println("Result of the third equation: " + solveThirdEquation(0.58, -0.34, 1.25, 1.89));
    }
}
