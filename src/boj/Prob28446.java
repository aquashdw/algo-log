package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/28446
public class Prob28446 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        Map<Integer, String> closets = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            String[] tokens = line.split(" ");
            if (tokens.length == 3) closets.put(Integer.parseInt(tokens[2]), tokens[1]);
            if (tokens.length == 2) answer.append(closets.get(Integer.parseInt(tokens[1]))).append('\n');
        });
        System.out.print(answer);
    }
}
