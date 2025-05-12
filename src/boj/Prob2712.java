package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

// https://www.acmicpc.net/problem/2712
public class Prob2712 {
    private static final Map<String, Double> conversion = Map.of(
            "kg", 2.2046,
            "lb", 0.4536,
            "l", 0.2642,
            "g", 3.7854
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).forEach(line -> {
            String[] split = line.split(" ");
            double value = Double.parseDouble(split[0]);
            String unit = split[1];
            switch (unit) {
                case "kg" -> answer.append(String.format("%.4f lb%n", value * conversion.get(unit)));
                case "lb" -> answer.append(String.format("%.4f kg%n", value * conversion.get(unit)));
                case "l" -> answer.append(String.format("%.4f g%n", value * conversion.get(unit)));
                case "g" -> answer.append(String.format("%.4f l%n", value * conversion.get(unit)));
            }
        });
        System.out.print(answer);
    }
}
