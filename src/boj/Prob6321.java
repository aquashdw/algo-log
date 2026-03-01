package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/6321
public class Prob6321 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append(String.format("String #%d", test + 1)).append('\n');
            answer.append(reader.readLine().chars().map(i -> i - 'A')
                            .map(i -> (i + 1) % 26)
                            .map(i -> i + 'A')
                            .mapToObj(i -> String.valueOf((char) i))
                            .collect(Collectors.joining("")))
                    .append("\n\n");
        }
        System.out.print(answer);
    }
}
