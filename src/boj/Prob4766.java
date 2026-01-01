package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4766
public class Prob4766 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double prev = Double.parseDouble(reader.readLine());
        double[] temps = reader.lines().takeWhile(line -> !line.equals("999"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        StringBuilder answer = new StringBuilder();
        for (double temp : temps) {
            answer.append(String.format("%.2f%n", temp - prev));
            prev = temp;
        }
        System.out.print(answer);
    }
}
