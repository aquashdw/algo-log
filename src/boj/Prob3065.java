package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3065
public class Prob3065 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] results = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] players = Arrays.stream(reader.readLine().split(" "))
                    .skip(1).mapToInt(Integer::parseInt).toArray();

            for (int player : players) {
                int base = 1;
                for (int j = 0; j < n; j++) {
                    base *= 2;
                }
                int offsetBase = base;
                int offset = 0;
                int result = (player - 1) / 2;
                int wins = 0;
                while (offset + result < base - 1 && results[offset + result] == player) {
                    wins++;
                    offsetBase /= 2;
                    offset += offsetBase;
                    result /= 2;
                }

                int changes = 0;
                int winner = player;
                while (offset + result < base - 1) {
                    if (results[offset + result] != winner) {
                        changes++;
                        winner = results[offset + result];
                    }
                    offsetBase /= 2;
                    offset += offsetBase;
                    result /= 2;
                }

                int bestPlace = changes + 1;
                int worstPlace = base;
                int lows = 1;
                while (wins > 0) {
                    wins--;
                    worstPlace -= lows;
                    lows *= 2;
                }
                answer.append(String.format("Player %d can be ranked as high as %d or as low as %d.%n", player, bestPlace, worstPlace));
            }

            answer.append('\n');
        }

        System.out.print(answer);
    }

}
