package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/16507
public class Prob16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rcq = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int r = rcq[0];
        int c = rcq[1];
        int q = rcq[2];

        int[][] photo = new int[r + 1][c + 1];
        for (int i = 1; i < r + 1; i++) {
            int[] row = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (c + 1 - 1 >= 0) System.arraycopy(row, 0, photo[i], 1, c + 1 - 1);
        }

        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                photo[i][j] += photo[i][j - 1];
            }
            for (int j = 1; j < c + 1; j++) {
                photo[i][j] += photo[i - 1][j];
            }
        }

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(q).forEach(line -> {
            int[] query = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] leftUp = {query[0] - 1, query[1] - 1};
            int[] rightDown = {query[2], query[3]};

            int lumen = photo[rightDown[0]][rightDown[1]] - photo[rightDown[0]][leftUp[1]] - photo[leftUp[0]][rightDown[1]] + photo[leftUp[0]][leftUp[1]];
            int cells = (rightDown[0] - leftUp[0]) * (rightDown[1] - leftUp[1]);
            answer.append(lumen / cells).append('\n');
        });
        System.out.print(answer);
    }
}
