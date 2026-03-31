package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

// https://www.acmicpc.net/problem/5342
public class Prob5342 {
    private static final Map<String, Double> prices = Map.of(
            "Paper", 57.99,
            "Printer", 120.50,
            "Planners", 31.25,
            "Binders", 22.50,
            "Calendar", 10.95,
            "Notebooks", 11.20,
            "Ink", 66.95
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("$%.2f%n", reader.lines().takeWhile(line -> !line.equals("EOI"))
                .mapToDouble(prices::get)
                .sum());
    }
}
