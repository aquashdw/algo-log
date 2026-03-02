package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/5691
public class Prob5691 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(reader.lines().takeWhile(line -> !line.equals("0 0"))
                .map(line -> {
                    int[] ab = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
                    int c = 2 * ab[0] - ab[1];
                    return String.valueOf(c);
                })
                .collect(Collectors.joining("\n")));

    }
}
