// Class for calculating factorial
class Factorial {
    // Recursive method to calculate factorial
    public static int recursionExecute(int n) {
        assert(n >= 0);
        n = (n <= 1) ? 1 :  n * recursionExecute(n - 1);
        return n;
    }

    // Iterative method to calculate factorial
    public static int cycleExecute(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Main method to test factorial calculation
    public static void main(String[] args) {
        int n = 5;
        int resultRecursion = recursionExecute(n);
        int resultCycle = cycleExecute(n);
        assert resultRecursion == resultCycle : "different values";
        System.out.println("N: " + n);
        System.out.println("Factorial (Recursion): " + resultRecursion);
    }
}

// Class for calculating Fibonacci series
class Fibonacci {
    // Recursive method to calculate Fibonacci series
    public static int recursionExecute(int n) {
        n = n <= 1 ? n : recursionExecute(n - 1) + recursionExecute(n - 2);
        return n;
    }

    // Iterative method to calculate Fibonacci series
    public static int cycleExecute(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    // Main method to test Fibonacci series calculation
    public static void main(String[] args) {
        int n = 8;
        int resultRecursion = recursionExecute(n);
        int resultCycle = cycleExecute(n);
        assert resultRecursion == resultCycle : "different values";
        System.out.println("N: " + n);
        System.out.println("Fibonacci (Cycle): " + resultCycle);
    }
}

// Class for calculating sum of digits
class SumOfDigits {
    // Recursive method to calculate sum of digits
    public static int execute(int n) {
        n = n == 0 ? 0 : n % 10 + execute(n/10);
        return n;
    }

    // Main method to test sum of digits calculation
    public static void main(String[] args) {
        int n = 223;
        int result = execute(n);
        System.out.println("Input Number: " + n);
        System.out.println("Sum of Digits: " + result);
    }
}

// Class for calculating sum of two numbers using bitwise operations
class Sum {
    // Recursive method to calculate sum of two numbers
    public static int execute(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b; // Addition without carry using XOR operation
        int carry = (a & b) << 1; // Carry shifted left by 1 bit
        return execute(sum, carry); // Operation is repeated until b != 0
    }

    // Main method to test sum of two numbers calculation
    public static void main(String[] args) {
        int a = 7, b = 6;
        int result = execute(a, b);
        System.out.println("Input Numbers\na = " + a + "\nb = " + b);
        System.out.println("Sum is: " + result);
    }
}

/**
 * Main3
 */


public class Main {
    public static void main(String[] args) {
        // Execute the main functions in the Factorial class
        Factorial.main(args);
        // Execute the main functions in the Fibonacci class
        Fibonacci.main(args);
        // Execute the main functions in the SumOfDigits class
        SumOfDigits.main(args);
        // Execute the main functions in the Sum class
        Sum.main(args);
    }
}

