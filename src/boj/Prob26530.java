package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26530
public class Prob26530 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int items = Integer.parseInt(reader.readLine());
            answer.append("$").append(String.format("%.2f%n", reader.lines().limit(items).mapToDouble(line -> {
                String[] set = line.split(" ");
                int count = Integer.parseInt(set[1]);
                double price = Double.parseDouble(set[2]);
                return count * price;
            }).sum()));
        }
        System.out.print(answer);
    }
}
