package Lab6;

public class Lab6 {

        public static String intToBinaryString(int i) {
            return Integer.toBinaryString(i);
        }

        public static String replaceWordsWithLowercase(String input) {
            if (input == null) {
                throw new NullPointerException("Input string cannot be null");
            }

            String[] parts = input.split(" ");
            StringBuilder result = new StringBuilder();

            for (String part : parts) {
                if (part.matches("[a-zA-Z]+")) {
                    result.append(part.toLowerCase());
                } else {
                    result.append(part);
                }
                result.append(" ");
            }

            return result.toString().trim();
        }

        public static void main(String[] args) {
            try {
                System.out.println("Двійкове представлення числа 7: " + intToBinaryString(15));
                System.out.println("Двійкове представлення числа 0: " + intToBinaryString(0));
                System.out.println("Двійкове представлення числа -4: " + intToBinaryString(-4));
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid argument: " + e.getMessage());
            }

            try {
                String sentence = "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
                System.out.println("Преобразоване речення: " + replaceWordsWithLowercase(sentence));
            } catch (NullPointerException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
}
