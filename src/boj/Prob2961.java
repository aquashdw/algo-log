package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2961
public class Prob2961 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] ingredients = new int[n][];
        for (int i = 0; i < n; i++) {
            ingredients[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < 1 << n; i++) {
            int sour = 1;
            int bitter = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) {
                    sour *= ingredients[j][0];
                    bitter += ingredients[j][1];
                }
            }
            minDiff = Math.min(Math.abs(sour - bitter), minDiff);
        }
        System.out.println(minDiff);
    }
}
