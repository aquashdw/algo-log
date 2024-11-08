package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13220
public class Prob13220 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] messageA = new long[n * 2];
        String[] messageARaw = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            messageA[i] = Long.parseLong(messageARaw[i]);
            messageA[n + i] = messageA[i];
        }
        long[] messageB = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        int[] lps = new int[n];
        int pIdx = 0;
        for (int idx = 1; idx < n; idx++) {
            while (pIdx > 0 && messageB[pIdx] != messageB[idx]) pIdx = lps[pIdx - 1];
            if (messageB[idx] == messageB[pIdx]) {
                pIdx++;
                lps[idx] = pIdx;
            }
        }

        pIdx = 0;
        for (int i = 0; i < n * 2; i++) {
            while (pIdx > 0 && messageA[i] != messageB[pIdx]) pIdx = lps[pIdx - 1];
            if (messageA[i] == messageB[pIdx]) {
                if (pIdx == n - 1) {
                    System.out.println("YES");
                    return;
                }
                else pIdx++;
            }
        }
        System.out.println("NO");
    }
}
