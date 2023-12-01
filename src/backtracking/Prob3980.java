package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3980 {
    private int maxStats;
    private int[][] statMap;
    private boolean[] picked;

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            maxStats = 0;
            statMap = new int[11][11];
            picked = new boolean[11];
            for (int j = 0; j < 11; j++) {
                StringTokenizer statToken = new StringTokenizer(reader.readLine());
                for (int k = 0; k < 11; k++) {
                    statMap[j][k] = Integer.parseInt(statToken.nextToken());
                }
                pickPosition(0, 0);
            }
            answerBuilder.append(maxStats).append('\n');
        }
        System.out.println(answerBuilder);
    }

    private void pickPosition(int player, int currentMax) {
        if (player == 11) {
            maxStats = Math.max(maxStats, currentMax);
        }
        else for (int i = 0; i < 11; i++) {
            if (picked[i] || statMap[i][player] == 0) continue;
            picked[i] = true;
            pickPosition(player + 1, currentMax + statMap[i][player]);
            picked[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        new Prob3980().solution();
    }
}
