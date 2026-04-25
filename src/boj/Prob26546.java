package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/26546
public class Prob26546 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(tests).map(line -> {
            String[] tokens = line.split(" ");
            int start = Integer.parseInt(tokens[1]);
            int end = Integer.parseInt(tokens[2]);
            return tokens[0].substring(0, start) + tokens[0].substring(end);
        }).collect(Collectors.joining("\n")));

    }
}
