package Lab5;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Найменший елемент:" + min);
    }
}
