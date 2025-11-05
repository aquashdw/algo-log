package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/13747
public class Prob13747 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        long slats = info[0];
        int k = (int) info[1];
        long[][] painters = new long[k + 1][3];
        for (int i = 1; i < k + 1; i++) {
            long[] painter = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            painters[i][0] = painter[0];
            painters[i][1] = painter[1];
            painters[i][2] = painter[1] - painter[0] + 1;
        }
        Arrays.sort(painters, Comparator.comparingLong(o -> o[1]));

        long[] dp = new long[k + 1];
        dp[0] = 0;
        for (int i = 1; i < k + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[binarySearch(painters, i)] + painters[i][2]);
        }
        System.out.println(slats - dp[k]);
    }

    private static int binarySearch(long[][] painters, int now) {
        int high = now - 1;
        int low = 0;
        long start = painters[now][0];
        while (low <= high) {
            int mid = (low + high) / 2;
            long end = painters[mid][1];
            if (end >= start) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }
}
