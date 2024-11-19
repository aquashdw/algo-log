package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/23385
public class Prob23385 {
    private static final double THRESH = 1e-9;

    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];
        double cable = Double.parseDouble(reader.readLine());
        double diagonal = Math.sqrt(m * m + 1);
        List<double[]> points = new ArrayList<>();
        List<Double> cableRecord = new ArrayList<>();
        cableRecord.add(cable);
        int x;
        for (x = 0; x < n; x++) {
            double[] next = new double[]{x, 0};
            points.add(next);
            // to be able to go down, after using m-cable there should be at least (n-x)-cable left
            if (n - x > cable - m) break;
            next = new double[]{x, m};
            points.add(next);
            cable -= m;
            cableRecord.add(cable);
            // to be able to go up, after using diagonal cable there should be at least toGoal(x + 1, 0)-cable left
            if (toGoal(x + 1, 0) > cable - diagonal) break;
            cable -= diagonal;
            cableRecord.add(cable);
        }

        double[] last = points.get(points.size() - 1);
        if (last[1] == m) {
            x += 1;
            double high = 0;
            double low = m;
            double y = (high + low) / 2;
            double dist = dist(x, y, last);
            // 사용한 양 - 남은 양
            double diff = dist - cable;
            while (Math.abs(diff) > THRESH) {
                // 덜 썻다 => 더 써야한다
                if (diff < 0) {
                    low = y;
                }
                else {
                    high = y;
                }
                y = (high + low) / 2;
                dist = dist(x, y, last);
                diff = dist - cable;
            }
            points.add(new double[]{x, y});
        }
        else {
            // 대각 방향에서 멈추면 X를 결정해야 한다.
            double left = x;
            double right = n;
            double midX = (left + right) / 2;
            double dist = dist(midX, 0, last);
            double diff = dist - cable;
            while (Math.abs(diff) > THRESH) {
                // 덜 썻다 => 더 써야 된다 => 좀더 뒤로 보내야 한다.
                if (diff < 0) {
                    left = midX;
                }
                else {
                    right = midX;
                }
                midX = (left + right) / 2;
                dist = dist(midX, 0, last);
                diff = dist - cable;
            }
            points.add(new double[]{midX, 0});
        }
        points.add(new double[]{n, m});
        StringBuilder answer = new StringBuilder();
        answer.append(points.size()).append('\n');
        for (double[] point : points) {
            answer.append(point[0]).append(' ').append(point[1]).append('\n');
        }
        System.out.print(answer);

        // Validate
//        double total = 0;
//        for (int i = 0; i < points.size() - 1; i++) {
//            double[] a = points.get(i);
//            double[] b = points.get(i + 1);
//            total += Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
//        }
//
//        double[] a = points.get(points.size() - 1);
//        double[] b = {n, m};
//        total += Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
//        System.out.println(total);
    }

    private static double toGoal(double x, double y) {
        return Math.sqrt((x - n) * (x - n) + (y - m) * (y - m));
    }


    private static double dist(double x, double y, double[] last) {
        double distToMid = Math.sqrt((last[0] - x) * (last[0] - x) + (last[1] - y) * (last[1] - y));
        double distToGoal = toGoal(x, y);
        return distToMid + distToGoal;
    }
}
/*
7 5
34

0.0 0.0
0.0 5.0
1.0 0.0
1.0 5.0
2.0 0.0
2.0 5.0
3.0 1.5949046378955245
7.0 5.0

 */
