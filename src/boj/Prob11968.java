package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11968
public class Prob11968 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int chance = 0;
        boolean[] cards = new boolean[n * 2 + 1];
        Arrays.fill(cards, true);
        reader.lines().limit(n).mapToInt(Integer::parseInt).forEach(i -> cards[i] = false);
        int score = 0;
        for (int i = 2 * n; i > 0; i--) {
            if (!cards[i]) {
                if (chance > 0) {
                    chance--;
                    score++;
                }
            } else chance++;
        }
        System.out.println(score);
    }

}
