package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1027
public class Prob1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] heights = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] count = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean canSee = true;
                long widthDiff = j - i;
                long heightDiff = heights[j] - heights[i];
                if (heightDiff == 0) {
                    for (int k = i + 1; k < j; k++) {
                        if (heights[k] < heights[j]) continue;
                        canSee = false;
                        break;
                    }
                } else for (int k = i + 1; k < j; k++) {
                    long xDiff = j - k;
                    long yDiff = heights[j] - heights[k];
                    if ((heightDiff < 0 && yDiff > 0) || (xDiff * heightDiff < widthDiff * yDiff)) continue;
                    canSee = false;
                    break;
                }
                if (canSee) {
                    count[i]++;
                    count[j]++;
                }
            }
        }
        System.out.println(Arrays.stream(count).max().orElseThrow());
    }
}
/*
12
1 3 2 5 4 6 4 7 2 1 10 3
 */