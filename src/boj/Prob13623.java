package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13623
public class Prob13623 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] zeroOrOne = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Arrays.stream(zeroOrOne).sum();
        if (sum == 0 || sum == 3) {
            System.out.println("*");
            return;
        }
        int key = switch (sum) {
            case 1 -> 1;
            case 2 -> 0;
            default -> throw new IllegalArgumentException();
        };

        for (int i = 0; i < 3; i++) {
            if (zeroOrOne[i] == key) {
                System.out.println((char) (i + 'A'));
                return;
            }
        }
    }
}
