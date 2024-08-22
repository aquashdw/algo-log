package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26031
public class Prob26031 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        long[] heights = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        int start = 0;
        long maxPeak = 0;
        long currentMax = 0;
        boolean asc = false;
        boolean desc = false;
        for (int i = 0; i < length - 1; i++) {
            if (heights[i] == heights[i + 1]) continue;
            if (heights[i] < heights[i + 1]) {
                if (desc) {
                    long thisPeak = Math.min(currentMax - heights[start], currentMax - heights[i]);
                    maxPeak = Math.max(maxPeak, thisPeak);
                    currentMax = 0;
                }
                if (!asc) {
                    start = i;
                    asc = true;
                    desc = false;
                }
            }
            else if (heights[i] > heights[i + 1]) {
                currentMax = Math.max(currentMax, heights[i]);
                asc = false;
                desc = true;
            }
        }
        if (desc) {
            maxPeak = Math.max(maxPeak, Math.min(currentMax - heights[length - 1], currentMax - heights[start]));
        }
        System.out.println(maxPeak);
    }
}
/*
10
1 2 3 4 5 4 3 2 1 0
11
0 1 2 3 4 5 4 3 2 1 0
9
29 85 88 12 52 37 6 86 7
10
29 85 88 12 52 37 6 86 7 90
3
3 2 1
3
1 2 3
3
2147483647 318000000000 2147483647
 */