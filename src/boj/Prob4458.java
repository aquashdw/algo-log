package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4458
public class Prob4458 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(lines)
                .map(line -> (new StringBuilder()
                        .append(Character.toUpperCase(line.charAt(0))))
                        .append(line.substring(1))
                        .append('\n')
                        .toString())
                .forEach(answer::append);
        System.out.print(answer);
    }

}
