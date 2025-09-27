package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/12347
public class Prob12347 {
//    private static final long MAX = 1_000_000_000_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        int count = 0;
        // 첫자리가 start
        for (long start = 1; start < 10; start++) {
            // 초항이 n보다 큰지 점검하고 중단
            if (start > n) break;
            // 단항 수열 한개 증가
            System.out.println(start);
            count++;
            // 공차가 i
            for (long i = 0; i < 10; i++) {
                // start * 10 ^ n + (start + d * i) * 10 ^ (n - 1) ...
                long num = start * 10;
                long next = start + i;
                if (next > 9) break;
                num += next;
                while (num <= n && num > 0) {
                    System.out.println(num);
                    count++;
                    num *= 10;
                    next += i;
                    if (next > 9) break;
                    num += next;
                }
            }

            for (long i = 1; i < 10; i++) {
                long num = start * 10;
                long next = start - i;
                if (next < 0) break;
                num += next;
                while (num <= n && num > 0) {
                    System.out.println(num);
                    count++;
                    num *= 10;
                    next -= i;
                    if (next < 0) break;
                    num += next;
                }
            }
        }
        System.out.println(count);
    }
}
// 1000000000000000000