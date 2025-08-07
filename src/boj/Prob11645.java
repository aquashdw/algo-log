package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/11645
public class Prob11645 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int count = Integer.parseInt(reader.readLine());
            answer.append(reader.lines().limit(count).collect(Collectors.toSet()).size()).append('\n');
        }
        System.out.print(answer);
    }
}
