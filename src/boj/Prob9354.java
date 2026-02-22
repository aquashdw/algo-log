package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9354
public class Prob9354 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            long[] speeds = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            int[] dirs = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(ch -> ch.charAt(0) == 'T' ? 1 : -1)
                    .toArray();
            long total = 0;
            long force = 0;

            for (int i = 0; i < n; i++) {
                if (dirs[i] == 1) {
                    force += speeds[i];
                    if (force > 0) {
                        total += force;
                        force = 0;
                    }
                } else {
                    force -= speeds[i];
                }
            }
            answer.append(total).append('\n');
        }
        System.out.print(answer);
    }
}
