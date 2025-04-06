package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14931
public class Prob14931 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(reader.readLine());
        long[] scores = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        int maxPower = 0;
        long maxScore = 0;
        for (int i = 0; i < n; i++) {
            int power = i + 1;
            int hit = power;
            long score = 0;
            while (hit - 1 < n) {
                score += scores[hit - 1];
                hit += power;
            }
            if (score > maxScore) {
                maxPower = power;
                maxScore = score;
            }
        }

        System.out.printf("%d %d%n", maxPower, maxScore);
    }
}
