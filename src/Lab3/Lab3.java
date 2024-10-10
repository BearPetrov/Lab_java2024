package Lab3;

public class Lab3 {
    public Lab3() {
    }

    public static void main(String[] args) {
        System.out.println("Task 1: Series Sum");
        printTask1Results(10.0, 5);
        printTask1Results(2.0, 34);
        printTask1Results(0.0, 20);
        printTask1Results(5.0, 35);
        System.out.println("\nTask 2: Function Value");
        printTask2Results(3.0, 10, 1);
        printTask2Results(4.0, 5, 2);
        printTask2Results(0.0, 5, 3);
        printTask2Results(2.0, 3, 7);
        System.out.println("\nTask 3: Infinite Sum");
        printTask3Results(0.001);
        printTask3Results(1.0E-5);
        printTask3Results(0.0);
    }

    public static double calculateTask1Sum(double s, int k) {
        if (k < 35 && !(s <= 0.0)) {
            double sum = 0.0;

            for(int i = 1; i <= k; ++i) {
                sum += Math.log10(Math.sqrt(s * (1.0 / (double)(i * i))));
            }

            return sum;
        } else {
            throw new IllegalArgumentException("Invalid parameters for Task 1: k must be less than 35 and s must be positive.");
        }
    }

    static void printTask1Results(double s, int k) {
        System.out.print("Task 1 -> s: " + s + ", k: " + k + " result: ");

        try {
            System.out.println(calculateTask1Sum(s, k));
        } catch (IllegalArgumentException var4) {
            IllegalArgumentException e = var4;
            System.out.println("EXCEPTION! " + e.getMessage());
        }

    }

    public static double calculateTask2Function(double t, int n, int l) {
        if (t <= 0.0) {
            throw new IllegalArgumentException("Invalid parameter t for Task 2: t must be greater than 0.");
        }
         else {
            double sum = 0.0;

            for(int i = 1; i <= n; ++i) {
                if (l % 2 == 0) {
                    sum += 1.0 / Math.sqrt(t) * (double)l;
                } else {
                    sum += 1.0 / t * (double)l;
                }
            }

            return sum;
        }
    }

    static void printTask2Results(double t, int n, int l) {
        System.out.print("Task 2 -> t: " + t + ", n: " + n + ", l: " + l + " result: ");

        try {
            System.out.println(calculateTask2Function(t, n, l));
        } catch (IllegalArgumentException var5) {
            IllegalArgumentException e = var5;
            System.out.println("EXCEPTION! " + e.getMessage());
        }

    }

    public static double calculateTask3InfiniteSum(double epsilon) {
        if (epsilon <= 0.0) {
            throw new IllegalArgumentException("Invalid epsilon for Task 3: ε must be greater than 0.");
        } else {
            double sum = 0.0;
            int i = 1;

            double term;
            do {
                term = 1.0 / (double)(i * i);
                sum += term;
                ++i;
            } while(term >= epsilon);

            return sum;
        }
    }

    static void printTask3Results(double epsilon) {
        System.out.print("Task 3 -> ε: " + epsilon + " result: ");

        try {
            System.out.println(calculateTask3InfiniteSum(epsilon));
        } catch (IllegalArgumentException var3) {
            IllegalArgumentException e = var3;
            System.out.println("EXCEPTION! " + e.getMessage());
        }

    }
}
