package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/31754
public class Prob31754 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        if (n == 1) {
            System.out.println("N");
            return;
        }
        Map<Long, Integer> factors = new HashMap<>();
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        if (count > 0) {
            factors.put(2L, count);
        }

        for (long i = 3; i * i <= n; i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                factors.put(i, count);
            }
        }

        if (n > 1) {
            factors.put(n, 1);
        }


        boolean success = true;
        if (factors.size() > 2) success = false;
        else if (factors.size() == 2 && factors.values().stream().mapToLong(l -> l).sum() > 2) success = false;
        else if (factors.size() == 1 && factors.values().stream().mapToLong(l -> l).sum() % 2 == 0) success = false;
        System.out.println(success ? "Y" : "N");
    }
}
