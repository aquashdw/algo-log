package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9699
public class Prob9699 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append(String.format("Case #%d: ", test + 1));
            answer.append(Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).max().orElse(0));
            answer.append('\n');
        }
        System.out.print(answer);

    }
}
