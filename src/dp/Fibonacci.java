package dp;

public class Fibonacci {
    public int fiboSimple(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fiboSimple(n - 1) + fiboSimple(n - 2);
    }

    public int fiboMemo(int n) {
        int[] memo = new int[n + 1];
        return fiboMemoRe(n, memo);
    }

    private int fiboMemoRe(int n, int[] memo) {
        if (n < 1) return 0;
        if (n == 1 || n == 2)
            return 1;
        else {
            if (memo[n] == 0) memo[n] = fiboMemoRe(n - 1, memo) + fiboMemoRe(n - 2, memo);
        }
        return memo[n];
    }

    public int fiboTab(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2)
            return 1;

        int[] fib = new int[n + 1];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        int n = 20;
        long start = System.nanoTime();
        System.out.println("simple");
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(fibo.fiboSimple(i)).append(' ');
        }
        System.out.println(resultBuilder);
        System.out.println(System.nanoTime() - start);
        System.out.println();


        start = System.nanoTime();
        System.out.println("memo");
        resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(fibo.fiboMemo(i)).append(' ');
        }
        System.out.println(resultBuilder);
        System.out.println(System.nanoTime() - start);
        System.out.println();


        start = System.nanoTime();
        System.out.println("tab");
        resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(fibo.fiboTab(i)).append(' ');
        }
        System.out.println(resultBuilder);
        System.out.println(System.nanoTime() - start);
        System.out.println();
    }
}
