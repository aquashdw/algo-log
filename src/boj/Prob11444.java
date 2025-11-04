package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/11444
public class Prob11444 {
    private static final Map<Long, Long> fibos = new HashMap<>();
    private static final long mod = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        System.out.println(fibo(n));
    }

    private static long fibo(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (fibos.containsKey(n)) return fibos.get(n);
        if (n % 2 == 0) {
            fibos.put(n, (fibo(n / 2) * (2 * fibo(n / 2 - 1) + fibo(n / 2))) % mod);
        } else {
            fibos.put(n, (fibo(n / 2 + 1) * fibo(n / 2 + 1) + fibo(n / 2) * fibo(n / 2)) % mod);
        }
        return fibos.get(n);
    }
}
