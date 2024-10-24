package Lab4;

public class Test {
    public static void main(String[] args) {
        int[] testArr = {-1, 4, -5, 6, -5};
        int sum = 0;
        for (int value : testArr) {
            if (value < 0){
            sum += value;}
        }
        System.out.println("Сума:" + sum);
    }

}
