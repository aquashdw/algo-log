package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5086
public class Prob5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.strip().equals("0 0")).forEach(line -> {
            int[] nums = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (nums[1] % nums[0] == 0) answer.append("factor");
            else if (nums[0] % nums[1] == 0) answer.append("multiple");
            else answer.append("neither");
            answer.append('\n');
        });
        System.out.print(answer);
    }
}
