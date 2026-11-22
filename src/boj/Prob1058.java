package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1058
public class Prob1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] relationships = new char[n][];
        for (int i = 0; i < n; i++) {
            relationships[i] = reader.readLine().toCharArray();
        }

        int max2Friends = 0;
        for (int i = 0; i < n; i++) {
            int now2Friends = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (relationships[i][j] == 'Y') {
                    now2Friends++;
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (relationships[i][k] == 'Y' && relationships[j][k] == 'Y') {
                        now2Friends++;
                        break;
                    }
                }
            }
            max2Friends = Math.max(max2Friends, now2Friends);
        }
        System.out.println(max2Friends);
    }
}
