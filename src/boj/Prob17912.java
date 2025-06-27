package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17912
public class Prob17912 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] debris = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < n; i++) {
            if (debris[i] < min) {
                min = debris[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }
}
