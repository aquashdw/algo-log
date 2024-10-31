package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11997
public class Prob11997 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[] usedX = new boolean[1000000];
        boolean[] usedY = new boolean[1000000];
        Queue<Integer> xSequenced = new PriorityQueue<>();
        Queue<Integer> ySequenced = new PriorityQueue<>();
        List<int[]> cows = new ArrayList<>(n);
        reader.lines().limit(n).map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .forEach(cow -> {
                    if (!usedX[cow[0]]) {
                        usedX[cow[0]] = true;
                        xSequenced.add(cow[0]);
                    }
                    if (!usedY[cow[1]]) {
                        usedY[cow[1]] = true;
                        ySequenced.add(cow[1]);
                    }
                    cows.add(cow);
                });
        Map<Integer, Integer> xComp = new HashMap<>();
        Map<Integer, Integer> yComp = new HashMap<>();
        int xCount = xSequenced.size();
        for (int i = 0; !xSequenced.isEmpty(); i++) {
            int x = xSequenced.poll();
            xComp.put(x, i * 2 + 1);
        }
        int yCount = ySequenced.size();
        for (int i = 0; !ySequenced.isEmpty(); i++) {
            int y = ySequenced.poll();
            yComp.put(y, i * 2 + 1);
        }
        cows.forEach(cow -> {
            cow[0] = xComp.get(cow[0]);
            cow[1] = yComp.get(cow[1]);
        });
        int[][] cowSums = new int[xCount + 1][yCount + 1];
        cows.forEach(cow -> {
            for (int i = (cow[0] + 1) / 2; i < xCount + 1; i++) {
                for (int j = (cow[1] + 1) / 2; j < yCount + 1; j++) {
                    cowSums[i][j]++;
                }
            }
        });

        int minMaxCows = Integer.MAX_VALUE;
        for (int i = 0; i < xCount + 1; i++) {
            for (int j = 0; j < yCount + 1; j++) {
                int leftUp = cowSums[i][j];
                int leftDown = cowSums[xCount][j] - leftUp;
                int rightUp = cowSums[i][yCount] - leftUp;
                int rightDown = n - leftUp - leftDown - rightUp;
                int localMax = Math.max(Math.max(leftUp, leftDown), Math.max(rightUp, rightDown));
                minMaxCows = Math.min(minMaxCows, localMax);
            }
        }
        System.out.println(minMaxCows);
    }
}
