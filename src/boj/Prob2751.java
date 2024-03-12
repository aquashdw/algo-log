package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/2751
public class Prob2751 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        new BufferedReader(new InputStreamReader(System.in)).lines()
                .skip(1)
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(i -> answer.append(i).append('\n'));
        System.out.println(answer);
    }
}
