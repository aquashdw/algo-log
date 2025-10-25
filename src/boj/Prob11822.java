package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11822
public class Prob11822 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int now = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int[] accepts = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            while (accepts[now] == 0) {
                now++;
                total++;
                if (now == 5) {
                    now = 0;
                    total += 2;
                }
            }
            now++;
            total++;
            if (i == n - 1) continue;
            if (now == 5) {
                now = 0;
                total += 2;
            }
        }
        System.out.println(total);
    }
}
