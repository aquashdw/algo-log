package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18398
public class Prob18398 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                int[] nums = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                answer.append(nums[0] + nums[1]).append(' ').append(nums[0] * nums[1]).append('\n');
            }
        }
        System.out.print(answer);
    }
}
