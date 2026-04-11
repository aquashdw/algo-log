package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/24768
public class Prob24768 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(line -> !line.equals("0 0"))
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .map(jars -> {
                    if (Arrays.stream(jars).sum() == 13) return "Never speak again.";
                    if (jars[0] > jars[1]) return "To the convention.";
                    if (jars[0] < jars[1]) return "Left beehind.";
                    return "Undecided.";
                })
                .collect(Collectors.joining("\n")));
    }

}
