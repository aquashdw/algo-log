package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/24267
public class Prob24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        if (n < 3) {
            System.out.println("0\n3");
            return;
        }
        long dividend = n * (n - 1) * (n - 2);
        long divisor = 6L;
        System.out.printf("%d%n%d%n", dividend / divisor, 3);

    }
}
