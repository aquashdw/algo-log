package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18298
public class Prob18298 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int bergs = Integer.parseInt(reader.readLine());
        long area = 0;
        for (int i = 0; i < bergs; i++) {
            int count = Integer.parseInt(reader.readLine());
            long[][] points = new long[count][];
            for (int j = 0; j < count; j++) {
                points[j] = Arrays.stream(reader.readLine().split(" "))
                        .mapToLong(Long::parseLong)
                        .toArray();
            }

            long bergArea = 0;
            for (int k = 0; k < count; k++) {
                long[] pointA = points[k];
                long[] pointB = points[(k + 1) % count];
                bergArea += (pointA[1] + pointB[1]) * (pointA[0] - pointB[0]);
            }
            area += Math.abs(bergArea);

//            long shoelace = 0;
//            for (int k = 0; k < count; k++) {
//                long[] pointA = points[k];
//                long[] pointB = points[(k + 1) % count];
//                shoelace += pointA[0] * pointB[1] - pointA[1] * pointB[0];
//            }
//            area += Math.abs(shoelace / 2);
        }
        area /= 2;
        System.out.println(area);
    }
}
