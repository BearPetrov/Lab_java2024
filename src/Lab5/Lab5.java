package Lab5;

public class Lab5 {

    public static void main(String[] args) {

        double[] array = {3.5, 2.1, 5.7, 1.9, 4.8};

        // Виконуємо сортування вибором
        selectionSort(array);
        System.out.println("Масив після сортування вибором:");
        printArray(array);

        // Ініціалізуємо масив для сортування вставками
        array = new double[]{3.5, 2.1, 5.7, 1.9, 4.8};

        // Виконуємо сортування вставками
        insertionSort(array);
        System.out.println("Масив після сортування вставками:");
        printArray(array);
    }

    // Сортування вибором по спаданню
    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Обмін місцями значень
            double temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }

    // Сортування вставками по спаданню
    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;
            // Переміщення елементів, що менші за ключ вправо
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Метод для виведення масиву
    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
