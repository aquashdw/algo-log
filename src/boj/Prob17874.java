package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17874
public class Prob17874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sides = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int topLeft = sides[1] * sides[2];
        int topRight = sides[1] * (sides[0] - sides[2]);
        int botLeft = (sides[0] - sides[1]) * sides[2];
        int botRight = (sides[0] - sides[1]) * (sides[0] - sides[2]);
        System.out.println(4 * Math.max(topLeft, Math.max(topRight, Math.max(botLeft, botRight))));

    }
}
