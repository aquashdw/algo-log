package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15025
public class Prob15025 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] tines = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        if (tines[0] == 0 && tines[1] == 0) {
            System.out.println("Not a moose");
            return;
        }

        if (tines[0] == tines[1]) {
            System.out.printf("Even %d%n", tines[0] * 2);
        } else {
            System.out.printf("Odd %d%n", Math.max(tines[0], tines[1]) * 2);
        }
    }
}
