package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20117
public class Prob20117 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] prices = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int total = 0;
        for (int i = 0; i < n / 2; i++) {
            total += prices[n - 1 - i] * 2;
        }
        if (n % 2 == 1) {
            total += prices[n / 2];
        }
        System.out.println(total);
    }
}
