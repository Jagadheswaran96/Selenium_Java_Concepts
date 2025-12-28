package selenium_java;

public class FindArmstrongNumber {

    // Function to check if a number is an Armstrong number
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int result = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int remainder = number % 10;
            result += Math.pow(remainder, digits);
            number /= 10;
        }

        return result == originalNumber;
    }

    public static void main(String[] args) {
        int num1 = 153;
        int num2 = 123;

        if (isArmstrong(num1)) {
            System.out.println(num1 + " is an Armstrong number.");
        } else {
            System.out.println(num1 + " is not an Armstrong number.");
        }

        if (isArmstrong(num2)) {
            System.out.println(num2 + " is an Armstrong number.");
        } else {
            System.out.println(num2 + " is not an Armstrong number.");
        }
    }
}

