package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2587
public class Prob2587 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        int[] nums = new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .limit(5)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        answer.append(Math.round(Arrays.stream(nums).average().orElseThrow())).append('\n');
        answer.append(nums[2]);
        System.out.print(answer);
    }
}
