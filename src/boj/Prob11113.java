package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11113
public class Prob11113 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pointCount = Integer.parseInt(reader.readLine());
        double[][] points = new double[pointCount][];
        for (int i = 0; i < pointCount; i++) {
            points[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        }

        int routeCount = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < routeCount; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] route = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            double distance = 0.0;
            for (int j = 0; j < n - 1; j++) {
                double[] start = points[route[j]];
                double[] end = points[route[j + 1]];
                distance += Math.sqrt(Math.pow(end[0] - start[0], 2) + Math.pow(end[1] - start[1], 2));
            }
            answer.append(Math.round(distance)).append('\n');
        }
        System.out.print(answer);
    }
}
