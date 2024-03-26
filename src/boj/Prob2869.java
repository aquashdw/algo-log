package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/2869
public class Prob2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] abv = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int up = abv[0];
        int down = abv[1];
        int height = abv[2];
        height -= up;
        int days = height / (up - down) + 1 + (height % (up - down) == 0 ? 0 : 1);

        System.out.println(days);
    }
}
