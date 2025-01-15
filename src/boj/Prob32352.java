package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32352
public class Prob32352 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrow = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] target = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();



        boolean xCrossNot = (arrow[0] <= target[0] && arrow[1] <= target[0]) || (arrow[0] >= target[1] && arrow[1] >= target[1]);
        boolean yCrossNot = (arrow[2] <= target[2] && arrow[3] <= target[2]) || (arrow[2] >= target[3] && arrow[3] >= target[3]);
        if (xCrossNot || yCrossNot) {
            System.out.println(-1);
            return;
        }

        if (arrow[5] <= target[4]) {
            System.out.println(-1);
            return;
        }

        int zDiff = arrow[4] - target[5];
        System.out.println(zDiff + 1);
    }
}
