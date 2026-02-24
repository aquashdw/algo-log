package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9085
public class Prob9085 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            answer.append(Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sum()).append('\n');
        }
        System.out.print(answer);
    }
}
