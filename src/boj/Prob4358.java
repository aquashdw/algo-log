package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/4358
public class Prob4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int total = 0;
        Map<String, Integer> trees = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            total++;
            trees.compute(line, (k, v) -> v == null ? 1 : v + 1);
        }

        StringBuilder answer = new StringBuilder();

        final int finalTotal = total;
        trees.keySet().stream()
                .sorted()
                .forEach(tree -> {
                    answer.append(tree).append(' ');
                    double percentage = (double) trees.get(tree) / finalTotal * 100;
                    answer.append(String.format("%.4f%n", percentage));
                });
        System.out.print(answer);
    }
}

