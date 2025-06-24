package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/25932
public class Prob25932 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            answer.append(line).append('\n');
            Set<Integer> nums = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            boolean mack = nums.contains(18);
            boolean zack = nums.contains(17);
            if (mack && zack)
                answer.append("both");
            else if (mack)
                answer.append("mack");
            else if (zack)
                answer.append("zack");
            else
                answer.append("none");
            answer.append("\n\n");
        });
        System.out.print(answer);
    }
}
