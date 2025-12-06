package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10179
public class Prob10179 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n)
                .mapToDouble(Double::parseDouble)
                .map(price -> price * 80 / 100)
                .forEach(price -> answer.append(String.format("$%.2f%n", price)));

        System.out.print(answer);
    }
}
