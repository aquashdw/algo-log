package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/14397
public class Prob14397 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[][] map = new boolean[mapInfo[0]][mapInfo[1]];
        IntStream.range(0, mapInfo[0]).forEach(i -> {
            try {
                String line = reader.readLine();
                IntStream.range(0, mapInfo[1]).forEach(j -> map[i][j] = line.charAt(j) == '#');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        int beachLength = 0;
        for (int i = 0; i < mapInfo[0]; i++) {
            for (int j = 0; j < mapInfo[1]; j++) {
                if (map[i][j]) {
                    if (j != 0) beachLength += map[i][j - 1] ? 0 : 1;
                    if (j != mapInfo[1] - 1) beachLength += map[i][j + 1] ? 0 : 1;
                    int leftY, rightY;
                    if (i % 2 == 0) {
                        leftY = j - 1;
                        rightY = j;
                    }
                    else {
                        leftY = j;
                        rightY = j + 1;
                    }
                    if (i != 0) {
                        if (leftY > -1) beachLength += map[i - 1][leftY] ? 0 : 1;
                        if (rightY < mapInfo[1]) beachLength += map[i - 1][rightY] ? 0 : 1;
                    }
                    if (i != mapInfo[0] - 1) {
                        if (leftY > -1) beachLength += map[i + 1][leftY] ? 0 : 1;
                        if (rightY < mapInfo[1]) beachLength += map[i + 1][rightY] ? 0 : 1;
                    }
                }
            }
        }

        System.out.println(beachLength);
    }
}
