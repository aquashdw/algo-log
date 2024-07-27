package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27515
public class Prob27515 {
    public static void main(String[] args) throws IOException {
        // 4611686018427387904
        // 2305843009213693952
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] twos = new int[63];
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long query = Long.parseLong(reader.readLine());
            if (query != 0) {
                int sign = query > 0 ? 1 : -1;
                int idx = (int) (Math.log(Math.abs(query)) / Math.log(2));
                if (sign > 0) twos[idx]++;
                else twos[idx]--;
            }
            int maxIdx = -1;
            int count = twos[0];
            for (int j = 0; j < 62; j++) {
                if (count == 0) {
                    count = twos[j + 1];
                }
                else if (count == 1) {
                    maxIdx = j;
                    count = twos[j + 1];
                }
                else if (count >= 2) {
                    maxIdx = j + 1;
                    count = twos[j + 1] + count / 2;
                }
            }
            if (count > 0) maxIdx = 62;
            if (maxIdx == -1) answer.append(0).append('\n');
            else answer.append((long) Math.pow(2, maxIdx)).append('\n');
        }
        System.out.print(answer);
    }
}
