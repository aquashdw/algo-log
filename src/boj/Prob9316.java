package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/9316
public class Prob9316 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        IntStream.range(1, n + 1).forEach(i -> answer.append(String.format("Hello World, Judge %d!\n", i)));
        System.out.print(answer);
    }
}
