package bf;

public class Factorial {
    public int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        Factorial fact = new Factorial();
        System.out.println(fact.factorialIterative(n));
        System.out.println(fact.factorialRecursive(n));

    }
}
