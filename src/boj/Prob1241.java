package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1241
public class Prob1241 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();
        int max = Arrays.stream(nums).max().orElseThrow();
        int[] counts = new int[max + 1];
        Arrays.stream(nums).forEach(num -> counts[num]++);

        StringBuilder answer = new StringBuilder();
        for (int num : nums) {
            int count = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    count += counts[i];
                    if (num / i != i) count += counts[num / i];
                }
            }
            answer.append(count - 1).append('\n');
        }
        System.out.print(answer);
    }
}
