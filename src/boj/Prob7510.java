package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7510
public class Prob7510 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 1; test < tests + 1; test++) {
            answer.append(String.format("Scenario #%d:%n", test));
            int[] edges = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();
            if (edges[0] * edges[0] + edges[1] * edges[1] == edges[2] * edges[2]) answer.append("yes\n");
            else answer.append("no\n");
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
