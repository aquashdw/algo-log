package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13985
public class Prob13985 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = Arrays.stream(reader.readLine().split(" "))
                .toArray(String[]::new);

        int operandA = Integer.parseInt(tokens[0]);
        int operandB = Integer.parseInt(tokens[2]);
        int sum = Integer.parseInt(tokens[4]);
        System.out.println(sum == operandA + operandB ? "YES" : "NO");
    }
}
