package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32369
public class Prob32369 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int goodOnion = 1;
        int badOnion = 1;
        for (int i = 0; i < info[0]; i++) {
            goodOnion += info[1];
            badOnion += info[2];
            if (goodOnion == badOnion) {
                badOnion--;
            } else if (goodOnion < badOnion) {
                int temp = badOnion;
                badOnion = goodOnion;
                goodOnion = temp;
            }
        }
        System.out.printf("%d %d%n", goodOnion, badOnion);
    }
}
