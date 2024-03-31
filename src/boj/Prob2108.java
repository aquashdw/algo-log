package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/2108
public class Prob2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // -4000 -> 0, 0-> 4000, 4000 -> 8000
        int[] count = new int[8001];
        int[] nums = reader.lines().limit(n).mapToInt(line -> {
            int i = Integer.parseInt(line);
            count[i + 4000]++;
            return i;
        })
                .sorted()
                .toArray();
        long avg = Math.round(Arrays.stream(nums).average().orElseThrow());
        int cen = nums[n / 2];
        int max = Arrays.stream(nums).max().orElseThrow();
        int min = Arrays.stream(nums).min().orElseThrow();

        int mostCount = 0;
        int mostCountIdxHigh = 0;
        int mostCountIdxLow = -1;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (count[i] > mostCount) {
                mostCount = count[i];
                mostCountIdxHigh = i;
                mostCountIdxLow = -1;
            }
            else if (count[i] == mostCount && mostCountIdxLow == -1) {
                mostCountIdxLow = mostCountIdxHigh;
                mostCountIdxHigh = i;
            }
        }

        int mostCountIdx = mostCountIdxHigh - 4000;

        System.out.printf("%d%n%d%n%d%n%d%n", avg, cen, mostCountIdx, max - min);
    }
}
