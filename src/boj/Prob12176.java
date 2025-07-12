package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12176
public class Prob12176 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int range = info[0];
            int blandCeil = info[1];
            int count = 0;
            for (int r = 0; r < range + 1; r++) {
                for (int g = Math.max(0, r - blandCeil); g < Math.min(r + blandCeil, range) + 1; g++) {
                    int minBlue = Math.max(r - blandCeil, g - blandCeil);
                    minBlue = Math.max(minBlue, 0);
                    int maxBlue = Math.min(r + blandCeil, g + blandCeil);
                    maxBlue = Math.min(maxBlue, range);
                    count += maxBlue - minBlue + 1;
                }
            }
            answer.append(String.format("Case #%d: ", test + 1)).append(count).append('\n');
        }
        System.out.print(answer);
    }
}
