package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9295
public class Prob9295 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            answer.append(String.format("Case %d: ", i + 1))
                    .append(Arrays.stream(reader.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .sum())
                    .append('\n');
        }

        System.out.print(answer);
    }
}
