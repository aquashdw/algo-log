package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/28113
public class Prob28113 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mins = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bus = mins[1];
        int sub = mins[2];
        if (bus == sub) System.out.println("Anything");
        else if (bus < sub) System.out.println("Bus");
        else System.out.println("Subway");
    }
}
