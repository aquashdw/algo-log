package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2506
public class Prob2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] correct = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int streak = 1;
        int score = 0;
        for (int i = 0; i < n; i++) {
            if (correct[i] == 1) {
                score += streak;
                streak++;
            }
            else streak = 1;
        }
        System.out.println(score);
    }
}
