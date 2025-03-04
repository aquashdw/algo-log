package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11945
public class Prob11945 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().split(" ")[0]);
        reader.lines().limit(n)
                .forEach(line -> answer.append(new StringBuilder(line).reverse()).append('\n'));
        System.out.print(answer);
    }
}
