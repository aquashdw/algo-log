package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/32754
public class Prob32754 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nr[0];
        int r1 = nr[1];
        System.out.println(reader.lines().limit(n).map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .filter(device -> {
                    double[] center = {
                            (double) (device[0] + device[2] + device[4] + device[6]) / 4,
                            (double) (device[1] + device[3] + device[5] + device[7]) / 4,
                    };
                    double centerDist = Math.sqrt(center[0] * center[0] + center[1] * center[1]);
                    double xDiffHalf = (double) (Math.abs(device[0] - device[4])) / 2;
                    double yDiffHalf = (double) (Math.abs(device[1] - device[5])) / 2;
                    double r2 = Math.sqrt(xDiffHalf * xDiffHalf + yDiffHalf * yDiffHalf);
                    double range = r1 + r2;
                    return centerDist - range < 0.00000000001;
                })
                .count());
    }
}
