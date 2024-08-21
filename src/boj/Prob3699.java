package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/3699
public class Prob3699 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] towerInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] tower = new int[towerInfo[0]][];
            for (int j = 0; j < towerInfo[0]; j++) {
                tower[j] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            answer.append(calculate(tower, towerInfo[1], towerInfo[0])).append('\n');
        }

        System.out.print(answer);
    }

    private static int calculate(int[][] tower, int width, int height) {
        Queue<int[]> cars = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[] beltDoor = new int[height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tower[i][j] != -1) {
                    cars.offer(new int[]{i, j, tower[i][j]});
                }
            }
        }
        int time = 0;
        while (!cars.isEmpty()) {
            int[] car = cars.poll();
            time += car[0] * 20;
            int idxDiff = Math.abs(beltDoor[car[0]] - car[1]);
            int minDiff = Math.min(idxDiff, width - idxDiff);
            beltDoor[car[0]] = car[1];
            time += minDiff * 5;
        }

        return time;
    }
}
