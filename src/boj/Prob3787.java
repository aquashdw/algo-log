package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/3787
public class Prob3787 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(Objects::nonNull).map(line -> {
            int n = Integer.parseInt(line);
            int counted = 0;
            int lastNum = -1;
            for (int i = 1; i < n + 1; i++) {
                counted += i;
                if (counted >= n) {
                    lastNum = i;
                    break;
                }
            }
            int retract = n - (counted - lastNum);
            int numerator = lastNum - retract + 1;
            int denominator = retract;
            if (lastNum % 2 == 0) {
                int temp = numerator;
                numerator = denominator;
                denominator = temp;
            }
            return String.format("TERM %d IS %d/%d", n, numerator, denominator);
        }).collect(Collectors.joining("\n")));
    }
}
