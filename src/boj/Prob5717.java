package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5717
public class Prob5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().forEach(line -> {
            if (line.equals("0 0")) return;
            answer.append(Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum())
                    .append('\n');
        });
        System.out.print(answer);
    }
}
