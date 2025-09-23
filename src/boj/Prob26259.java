package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26259
public class Prob26259 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = nm[0];
        int cols = nm[1];
        int[][] rooms = new int[rows][];
        for (int i = 0; i < rows; i++) {
            rooms[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[rows][cols];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        dp[0][0] = rooms[0][0];

        int[] walls = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean ySame = walls[0] == walls[2];
        boolean xSame = walls[1] == walls[3];
        int[] range = new int[2];
        int wall = -1;
        if (xSame && !ySame) {
            range[0] = Math.min(walls[0], walls[2]);
            range[1] = Math.max(walls[0], walls[2]);
            wall = walls[1];
        } else if (ySame && !xSame) {
            range[0] = Math.min(walls[1], walls[3]);
            range[1] = Math.max(walls[1], walls[3]);
            wall = walls[0];
        }

        // row == 0
        for (int i = 1; i < cols; i++) {
            // y값은 같고 x값은 다름 (x 축과 평행한 벽이 있음)
            // 벽이 0 부터 시작
            // 벽의 경계를 넘었음
            if (xSame && !ySame && range[0] == 0 && i == wall) break;
            dp[0][i] = dp[0][i - 1] + rooms[0][i];
        }
        // col == 0
        for (int i = 1; i < rows; i++) {
            // x값은 같고 y값은 다름 (y 축과 평행한 벽이 잇음)
            // 벽이 0 부터 시작
            // 벽의 경계를 넘었음
            if (ySame && !xSame && range[0] == 0 && i == wall) break;
            dp[i][0] = dp[i - 1][0] + rooms[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 위쪽 벽이 없으면 위쪽 값과 비교
                if (!(ySame && !xSame && wall == i && range[0] <= j && j < range[1])) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
                // 왼쪽 벽이 없으면 왼쪽 값과 비교
                if (!(xSame && !ySame && wall == j && range[0] <= i && i < range[1])) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
                }
                // 만약 dp[i][j]가 0이 아니라면 도달 가능한 곳이니 방의 값을 추가
                if (dp[i][j] != Integer.MIN_VALUE) dp[i][j] += rooms[i][j];
            }
        }

        System.out.println(dp[rows - 1][cols - 1] == Integer.MIN_VALUE ? "Entity" : dp[rows - 1][cols - 1]);
    }
}

/*
2 2
-1 -1
-1 -1
0 0 0 0

3 3
1 1 1
1 1 1
1 1 1
1 0 1 3

3 3
1 1 1
1 1 1
1 1 1
0 1 3 1

3 3
1 1 1
1 1 1
1 1 1
1 0 1 2

3 3
1 1 1
1 1 1
1 1 1
0 1 2 1

3 3
1 1 1
1 1 1
1 1 1
0 0 0 0

3 3
1 1 1
1 1 1
1 1 1
2 0 2 2

4 4
1 2 8 7
3 2 1 4
7 8 2 1
2 6 2 1
3 1 3 3

 */