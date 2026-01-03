package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4493
public class Prob4493 {
    public static void main(String[] args) throws IOException {
//        System.out.println('R' - 'S');
//        System.out.println('S' - 'P');
//        System.out.println('P' - 'R');

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int player1 = 0;
            int player2 = 0;
            for (int i = 0; i < n; i++) {
                int[] rps = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(play -> play.charAt(0)).toArray();

                if (rps[0] == rps[1]) continue;
                int diff = rps[0] - rps[1];
                int diffAbs = Math.abs(diff);
                switch (diffAbs) {
                    case 1, 2 -> {
                        if (diff > 0) player2++;
                        else player1++;
                    }
                    case 3 -> {
                        if (diff > 0) player1++;
                        else player2++;
                    }
                }
            }
            if (player1 == player2) {
                answer.append("TIE\n");
                continue;
            }
            answer.append(player1 > player2 ? "Player 1\n" : "Player 2\n");
        }
        System.out.print(answer);
    }
}
