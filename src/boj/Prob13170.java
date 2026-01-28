package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13170
public class Prob13170 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int maxPower = info[2];
        int dangerDiff = info[3];

        System.out.println(maxPower / dangerDiff + (maxPower % dangerDiff == 0 ? 0 : 1));
    }

}

