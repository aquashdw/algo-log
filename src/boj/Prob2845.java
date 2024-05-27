package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2845
public class Prob2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int people = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .reduce(1, (product, now) -> product * now);

        StringBuilder answer = new StringBuilder();
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(str -> Integer.parseInt(str) - people)
                .forEach(i -> answer.append(i).append(' '));

        System.out.println(answer);
    }
}
