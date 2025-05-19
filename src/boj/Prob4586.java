package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/4586
public class Prob4586 {
    private static int[][] image;
    private static int threshold;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int imageIdx = 0;
        String line;
        while (!(line = reader.readLine()).equals("0")) {
            imageIdx++;
            answer.append("Image ").append(imageIdx).append(":\n");
            int[] info = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            image = new int[info[0]][];
            threshold = info[1];

            for (int i = 0; i < info[0]; i++) {
                image[i] = reader.readLine().chars().map(ch -> ch - '0').toArray();
            }

            compress(0, 0, info[0]);
            for (int[] row : image) {
                answer.append(Arrays.stream(row)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining("")))
                        .append('\n');
            }
        }
        System.out.print(answer);
    }

    private static void compress(int luy, int lux, int width) {
        int threshCount = threshold * width * width;
        if (threshCount % 100 == 0) {
            threshCount = threshCount / 100;
        } else {
            threshCount /= 100;
            threshCount++;
        }

        int white = 0;
        int black = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                int y = luy + i;
                int x = lux + j;
                if (image[y][x] == 0) white++;
                else black++;
            }
        }

        if (white >= threshCount) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    int y = luy + i;
                    int x = lux + j;
                    image[y][x] = 0;
                }
            }
        } else if (black >= threshCount) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    int y = luy + i;
                    int x = lux + j;
                    image[y][x] = 1;
                }
            }
        } else {
            int half = width / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    compress(luy + i * half, lux + j * half, half);
                }
            }
        }
    }
}
