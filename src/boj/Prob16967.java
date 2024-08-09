package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/16967
public class Prob16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int height = matInfo[0];
        int width = matInfo[1];
        int hOffset = matInfo[2];
        int wOffset = matInfo[3];
        int bigH = height + hOffset;
        int[][] merged = new int[bigH][];
        for (int i = 0; i < bigH; i++) {
            merged[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                merged[i + hOffset][j + wOffset] -= merged[i][j];
                answer.append(merged[i][j]).append(" ");
            }
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
