package Lab5;

public class Lab5 {

    public static void main(String[] args) {

        double[] array = {3.5, 2.1, 5.7, 1.9, 4.8};

        selectionSort(array);
        System.out.println("Масив після сортування вибором:");
        printArray(array);

        array = new double[]{3.5, 2.1, 5.7, 1.9, 4.8};

        insertionSort(array);
        System.out.println("Масив після сортування вставками:");
        printArray(array);
    }

    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            double temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
