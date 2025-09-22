package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32867
public class Prob32867 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];
        int[] keys = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int localMin = Integer.MAX_VALUE;
        int localMax = 0;
        int moves = 0;
        for (int i = 0; i < keys.length; i++) {
            localMin = Math.min(localMin, keys[i]);
            localMax = Math.max(localMax, keys[i]);
            if (localMax - localMin > m - 1) {
                moves++;
                localMin = keys[i];
                localMax = keys[i];
            }
        }
        System.out.println(moves);
    }
}
