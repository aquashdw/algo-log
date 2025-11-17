package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/19355
public class Prob19355 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (n == 1) {
                answer.append(arr[0]).append('\n');
                continue;
            }
            if (n == 2) {
                answer.append(Math.max(arr[0], arr[1])).append('\n');
                continue;
            }
            long[] sums = new long[n];
            sums[0] = arr[0];
            long minOdd = sums[0];
            long minEven = 0;
            long maxSum = sums[0];
            for (int j = 1; j < n; j++) {
                sums[j] = sums[j - 1] + arr[j];
                if (j % 2 == 0) {
                    minOdd = Math.min(minOdd, sums[j]);
                    maxSum = Math.max(maxSum, sums[j] - minEven);
                } else {
                    minEven = Math.min(minEven, sums[j]);
                    maxSum = Math.max(maxSum, sums[j] - minOdd);
                }
            }

            answer.append(maxSum).append('\n');
        }
        System.out.print(answer);
    }
}
