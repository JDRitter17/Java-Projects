package dejavu;

public class Recursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int triangle(int n) {
        if (n == 0) {
            return 0;
        } else {
            return triangle(n - 1) + n;
        }
    }

    public static int multiply(int x, int y) {
        if (y == 0) {
            return 0;
        } else {
            return multiply(x, y - 1) + x;
        }

    }

    public static int power(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            return power(x, y - 1) * x;
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int nChooseK(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        } else {
            return nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
        }
    }

    public static String reverse(String n) {
        if (n == "") {
            return "";
        } else {
            return reverse(n.substring(1)) + n.charAt(0);
        }
    }

    public static boolean isPalindrome(String n) {
        if (n.length() < 2) {
            return true;
        }
        else{
            if (n.charAt(0) != n.charAt(n.length() - 1)){
                return false;
            }
            return isPalindrome(n.substring(1, n.length() -1));
        }
    }

}
