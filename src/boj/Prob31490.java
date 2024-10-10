package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/31490
public class Prob31490 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        double alice = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToDouble(sides -> (double) (sides + 1) / 2)
                .sum();
        double bob = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToDouble(sides -> (double) (sides + 1) / 2)
                .sum();
        if (alice == bob) System.out.println("TIED");
        else if (alice > bob) System.out.println("ALICE");
        else System.out.println("BOB");
    }
}
