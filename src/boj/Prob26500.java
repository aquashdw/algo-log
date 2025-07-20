package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26500
public class Prob26500 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .forEach(line -> {
                    double[] nums = Arrays.stream(line.split(" "))
                            .mapToDouble(Double::parseDouble)
                            .toArray();

                    answer.append(String.format("%.1f%n", Math.abs(nums[0] - nums[1])));
                });
        System.out.print(answer);
    }
}
