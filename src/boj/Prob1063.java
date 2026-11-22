package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


// https://acmicpc.net/problem/1063
public class Prob1063 {
    private static final Map<String, int[]> deltas = Map.of(
            "R", new int[]{1, 0},
            "L", new int[]{-1, 0},
            "B", new int[]{0, -1},
            "T", new int[]{0, 1},
            "RT", new int[]{1, 1},
            "LT", new int[]{-1, 1},
            "RB", new int[]{1, -1},
            "LB", new int[]{-1, -1}
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int[] king = {tokens[0].charAt(0) - 'A', tokens[0].charAt(1) - '1'};
        int[] stone = {tokens[1].charAt(0) - 'A', tokens[1].charAt(1) - '1'};
        int moves = Integer.parseInt(tokens[2]);
        for (int i = 0; i < moves; i++) {
            String move = reader.readLine();
            int[] delta = deltas.get(move);
            int nextKingX = king[0] + delta[0];
            int nextKingY = king[1] + delta[1];
            if (!checkBounds(nextKingX, nextKingY)) continue;
            if (!(nextKingX == stone[0] && nextKingY == stone[1])) {
                king[0] = nextKingX;
                king[1] = nextKingY;
                continue;
            }

            int nextStoneX = stone[0] + delta[0];
            int nextStoneY = stone[1] + delta[1];
            if (!checkBounds(nextStoneX, nextStoneY)) continue;
            king[0] = nextKingX;
            king[1] = nextKingY;
            stone[0] = nextStoneX;
            stone[1] = nextStoneY;
        }
        System.out.printf("%c%d%n%c%d%n", king[0] + 'A', king[1] + 1, stone[0] + 'A', stone[1] + 1);
    }

    private static boolean checkBounds(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
