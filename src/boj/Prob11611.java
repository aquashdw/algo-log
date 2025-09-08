package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/11611
public class Prob11611 {
    private static final int[][] deltas = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 0},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] whb = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int width = whb[0];
        int height = whb[1];
        int blurs = whb[2];
        int[][] image = new int[height][];
        for (int i = 0; i < height; i++) {
            image[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int blur = 0; blur < blurs; blur++) {
            int[][] newImage = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int gray = 0;
                    for (int[] delta : deltas) {
                        int y = (i + delta[0] + height) % height;
                        int x = (j + delta[1] + width) % width;
                        gray += image[y][x];
                    }
                    newImage[i][j] = gray;
                }
            }
            image = newImage;
        }
        Set<Integer> grays = new HashSet<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grays.add(image[i][j]);
            }
        }
        System.out.println(grays.size());
    }

}
