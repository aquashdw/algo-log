package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/4909
public class Prob4909 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(line -> !line.strip().equals("0 0 0 0 0 0"))
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .sorted()
                        .skip(1)
                        .limit(4)
                        .sum())
                .map(sum -> {
                    if (sum % 4 == 0) {
                        return String.valueOf(sum / 4);
                    } else return String.valueOf((double) sum / 4);
                })
                .collect(Collectors.joining("\n")));
    }
}
