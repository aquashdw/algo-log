package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15003
public class Prob15003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int x = Integer.parseInt(info[0]);
        int y = Integer.parseInt(info[1]);
        double radius = Double.parseDouble(info[2]);
        int[] points = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] start = Arrays.copyOfRange(points, 0, 2);
        int[] goal = Arrays.copyOfRange(points, 2, points.length);
        double unitY = radius / y;
        double baseX = radius * Math.PI / x;
        int xDiff = Math.abs(start[0] - goal[0]);
        int yMax = Math.max(start[1], goal[1]);
        int yMin = Math.min(start[1], goal[1]);
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < y + 1; i++) {
            double currentDist = 0;
            currentDist += Math.abs(yMax - i) * unitY + Math.abs(yMin - i) * unitY;
            currentDist += baseX * xDiff * i / y;
            minDist = Math.min(minDist, currentDist);
        }

        System.out.println(minDist);
    }
}
