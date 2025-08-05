package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30330
public class Prob30330 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] xPoints = new int[n];
        int[] yPoints = new int[n];
        for (int i = 0; i < n; i++) {
            int[] point = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            xPoints[i] = point[0];
            yPoints[i] = point[1];
        }
        Arrays.sort(xPoints);
        Arrays.sort(yPoints);
        System.out.printf("%d %d%n", xPoints[(n - 1) / 2], yPoints[(n - 1) / 2]);
    }
}
/*
18
0 2
1 1
1 2
1 3
2 0
2 1
2 2
2 3
2 4
2 5
3 1
3 2
3 3
3 4
3 5
4 2
4 3
4 4
5 3

15
0 2
1 1
1 2
1 3
2 0
2 1
2 2
2 3
2 4
2 5
3 1
3 2
3 3
3 4
3 5
4 2

 */