package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4696
public class Prob4696 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines()
                .mapToDouble(Double::parseDouble)
                .forEach(d -> {
                    if (d == 0) return;
                    double base = 1;
                    double sum = 0;
                    for (int i = 0; i < 5; i++) {
                        sum += base;
                        base *= d;
                    }
                    answer.append("%.2f".formatted(sum)).append('\n');
                });
        System.out.print(answer);
    }
}
