package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7571
public class Prob7571 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[] xPoints = new int[m];
        int[] yPoints = new int[m];
        for (int i = 0; i < m; i++) {
            int[] point = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            xPoints[i] = point[0];
            yPoints[i] = point[1];
        }

        Arrays.sort(xPoints);
        Arrays.sort(yPoints);
        int targetX = xPoints[m / 2];
        int targetY = yPoints[m / 2];
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += Math.abs(xPoints[i] - targetX) + Math.abs(yPoints[i] - targetY);
        }
        System.out.println(sum);
    }
}
