package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27932
public class Prob27932 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nk[0];
        int k = nk[1];

        long[] heights = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        if (n == 1) {
            System.out.println(0);
            return;
        }
//        long[] diffs = new long[heights.length - 1];
//        for (int i = 0; i < n - 1; i++) {
//            diffs[i] = Math.abs(heights[i] - heights[i + 1]);
//        }

        long start = 0;
        long end = Arrays.stream(heights).max().orElseThrow();
        long result = -1;

        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;
            count += Math.abs(heights[0] - heights[1]) > mid ? 1 : 0;
            count += Math.abs(heights[n - 2] - heights[n - 1]) > mid ? 1 : 0;
            for (int i = 1; i < n - 1; i++) {
                long leftDiff = Math.abs(heights[i] - heights[i - 1]);
                long rightDiff = Math.abs(heights[i] - heights[i + 1]);
                if (leftDiff > mid || rightDiff > mid) {
                    count++;
                }
                if (count > k) break;
            }

            if (count <= k) {
                result = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
/*
5 0
1 1 1 4 1
 */