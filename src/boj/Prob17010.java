package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17010
public class Prob17010 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            String[] tokens = reader.readLine().split(" ");
            int count = Integer.parseInt(tokens[0]);
            answer.append(tokens[1].repeat(count)).append('\n');
        }
        System.out.print(answer);
    }
}
