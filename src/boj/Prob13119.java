package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13119
public class Prob13119 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmx = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int height = nmx[0];
        int width = nmx[1];
        int highway = nmx[2] - 1;
        int[] mountain = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char[][] painting = new char[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < mountain[i]; j++) {
                painting[j][i] = '#';
            }
            for (int j = mountain[i]; j < height; j++) {
                painting[j][i] = '.';
            }
        }

        for (int i = 0; i < width; i++) {
            painting[highway][i] = painting[highway][i] == '#' ? '*' : '-';
            if (i % 3 == 2) {
                int next = highway - 1;
                while (next >= 0 && painting[next][i] == '.') {
                    painting[next][i] = '|';
                    next--;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < height; i++) {
            int idx = height - i - 1;
            answer.append(painting[idx]).append('\n');
        }
        System.out.print(answer);
    }
}
