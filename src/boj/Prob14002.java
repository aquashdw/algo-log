package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/14002
public class Prob14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = reader.lines().limit(1).mapToInt(Integer::parseInt).sum();
        int[] nums = new int[n + 1];
        System.arraycopy(
                Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                0,
                nums,
                1,
                n
        );
        int[] lengths = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int maxIdx = 0;
            int maxLength = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lengths[j] > maxLength) {
                    maxLength = lengths[j];
                    maxIdx = j;
                }
            }
            lengths[i] = maxLength + 1;
            prev[i] = maxIdx;
        }
        int maxIdx = 0;
        int maxLength = 0;
        for (int i = 1; i < n + 1; i++) {
            if (lengths[i] > maxLength) {
                maxLength = lengths[i];
                maxIdx = i;
            }
        }
        List<Integer> resultNums = new ArrayList<>(maxLength);
        int nextIdx = maxIdx;
        while (nextIdx != 0) {
            resultNums.add(nums[nextIdx]);
            nextIdx = prev[nextIdx];
        }
        Collections.reverse(resultNums);
        System.out.printf("%d%n%s%n", maxLength, resultNums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
