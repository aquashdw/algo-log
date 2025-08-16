package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2991
public class Prob2991 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] abcd = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] pmn = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        StringBuilder answer = new StringBuilder();
        for (int time : pmn) {
            int attacks = 0;
            int aPeriod = abcd[0] + abcd[1];
            int aTime = time % aPeriod;
            if (0 < aTime && aTime <= abcd[0]) {
                attacks++;
            }
            int bPeriod = abcd[2] + abcd[3];
            int bTime = time % bPeriod;
            if (0 < bTime && bTime <= abcd[2]) {
                attacks++;
            }
            answer.append(attacks).append('\n');
        }
        System.out.print(answer);

    }
}
