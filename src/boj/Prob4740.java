package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4740
public class Prob4740 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.equals("***"))
                .forEach(line -> answer
                        .append(new StringBuilder(line).reverse())
                        .append('\n'));
        System.out.print(answer);
    }
}
