package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27884
public class Prob27884 {
    private static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = nm[0];
        int m = nm[1];

//        reader.lines().skip(n);
        long total = 0;
        int[] rise = new int[n];
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                rise[j] = (i & (1 << j)) == 0 ? -1 : 1;
            }

            int maxCoaster = 0;
            int rollerCoaster = 1;
            for (int j = 1; j < n; j++) {
                if (rise[j - 1] != rise[j]) rollerCoaster++;
                else {
                    maxCoaster = Math.max(rollerCoaster, maxCoaster);
                    rollerCoaster = 1;
                }
            }
            maxCoaster = Math.max(rollerCoaster, maxCoaster);

            if (maxCoaster != m) continue;

            long count = 1;
            for (int j = 0; j < n; j++) {
                count = ((rise[j] > 0 ? 5 : 11) * count) % mod;
            }
            total = (total + count) % mod;
        }

        System.out.println(total);
    }
}
