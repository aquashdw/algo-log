package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2455
public class Prob2455 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] records = new int[4][];
        for (int i = 0; i < 4; i++) {
            records[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int now = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            now -= records[i][0];
            now += records[i][1];
            max = Math.max(max, now);
        }
        System.out.println(max);
    }
}

