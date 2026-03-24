package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/5361
public class Prob5361 {
    private static final double[] prices = {350.34, 230.90, 190.55, 125.30, 180.90};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            int[] pieces = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            answer.append(String.format("$%.2f%n", IntStream.range(0, 5).mapToDouble(i -> pieces[i] * prices[i]).sum()));
        }
        System.out.print(answer);
    }
}
