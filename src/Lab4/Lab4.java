package Lab4;

import java.util.Arrays;

public class Lab4 {
        // Завдання №20: Знайти суму від'ємних елементів
        public static int sumNegativeElements(int[] array) {
            int sum = 0;
            for (int value : array) {
                if (value < 0) {
                    sum += value; // Додаємо тільки від'ємні елементи
                }
            }
            return sum; // Повертаємо суму від'ємних елементів
        }

        // Завдання №50: Знайти максимальний парний елемент, індекс якого кратний 7
        public static int maxEvenElementWithIndexMultipleOfSeven(int[] array) {
            int max = Integer.MIN_VALUE; // Початково задаємо мінімальне значення
            for (int i = 0; i < array.length; i++) {
                if (i % 7 == 0 && array[i] % 2 == 0) { // Перевіряємо, чи індекс кратний 7 та елемент парний
                    if (array[i] > max) {
                        max = array[i]; // Знаходимо максимальний парний елемент
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("No even elements with index multiple of 7 found"); // Якщо не знайдено
            }
            return max;
        }

        // Завдання №66: Об'єднати два масиви A(n) і B(m) в один C(n+m)
        public static int[] mergeArrays(int[] arrayA, int[] arrayB) {
            int[] mergedArray = new int[arrayA.length + arrayB.length]; // Створюємо новий масив розміру n+m
            System.arraycopy(arrayA, 0, mergedArray, 0, arrayA.length); // Копіюємо елементи масиву A
            System.arraycopy(arrayB, 0, mergedArray, arrayA.length, arrayB.length); // Копіюємо елементи масиву B
            return mergedArray;
        }

        public static void main(String[] args) {
            // Приклад для завдання №20
            int[] testArray20 = {-1, 2, -3, 5, -8};
            System.out.println("Сума від'ємних елементів: " + sumNegativeElements(testArray20));

            // Приклад для завдання №50
            int[] testArray50 = {12, 5, 4, 6, 8, 10, 14, 18, 16};
            try {
                System.out.println("Максимальний парний елемент з індексом кратним 7: " + maxEvenElementWithIndexMultipleOfSeven(testArray50));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Приклад для завдання №66
            int[] arrayA = {1, 2, 3};
            int[] arrayB = {4, 5, 6};
            System.out.println("Об'єднаний масив: " + Arrays.toString(mergeArrays(arrayA, arrayB)));
        }
    }
