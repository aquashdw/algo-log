package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/33964
public class Prob33964 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int diff = Math.abs(digits[0] - digits[1]);
        int left = Math.max(digits[0], digits[1]) - diff;
        StringBuilder answer = new StringBuilder();
        answer.append("1".repeat(diff)).append("2".repeat(left));
        System.out.println(answer);
    }
}
