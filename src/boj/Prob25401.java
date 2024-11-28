package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25401
public class Prob25401 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int front = nums[i];
                int back = nums[j];
                if ((back - front) % (j - i) != 0) continue;

                int count = 0;
                int diff = (back - front) / (j - i);
                int next = front - diff * i;
                for (int k = 0; k < n; k++) {
                    if (nums[k] != next) count++;
                    next += diff;
                }
                minCount = Math.min(count, minCount);
            }
        }
        System.out.println(minCount);
    }
}
