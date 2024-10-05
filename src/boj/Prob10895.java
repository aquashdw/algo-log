package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10895
public class Prob10895 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ak = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = ak[0];
        int k = ak[1];

        if (k == 0) {
            System.out.println(a);
            return;
        }

        if (a == 1) {
            System.out.println(1);
            return;
        }

        if (a % 2 == 0) {
            System.out.println(1);
        }
        else {
            System.out.println(a);
        }
    }
}
