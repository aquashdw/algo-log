package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2490
public class Prob2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(3).forEach(line -> System.out.println(switch (Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .sum()) {
            case 0 -> 'D';
            case 1 -> 'C';
            case 2 -> 'B';
            case 3 -> 'A';
            case 4 -> 'E';
            default -> throw new IllegalArgumentException("Invalid input");
        }));
    }
}
