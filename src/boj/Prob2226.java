package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/2226
public class Prob2226 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        switch (n) {
            case 1 -> {
                System.out.println(0);
                return;
            }
            case 2, 3 -> {
                System.out.println(1);
                return;
            }
        }
        BigInteger[] zeroGroups = new BigInteger[n];
        BigInteger[] oneGroups = new BigInteger[n];
        boolean[] zeroStart = new boolean[n];

        zeroGroups[0] = BigInteger.ZERO;
        oneGroups[0] = BigInteger.ONE;
        zeroStart[0] = false;

        zeroGroups[1] = BigInteger.ONE;
        oneGroups[1] = BigInteger.ONE;
        zeroStart[1] = true;

        zeroGroups[2] = BigInteger.ONE;
        oneGroups[2] = BigInteger.TWO;
        zeroStart[2] = false;

        for (int i = 3; i < n; i++) {
            oneGroups[i] = oneGroups[i - 1].add(zeroGroups[i - 1]);
            zeroGroups[i] = zeroGroups[i - 1].add(oneGroups[i - 1]);
            if (zeroStart[i - 1]) {
                zeroGroups[i] = zeroGroups[i].subtract(BigInteger.ONE);
            }
            zeroStart[i] = !zeroStart[i - 1];
        }
        System.out.println(zeroGroups[n - 1]);
    }
}
/*
1 = 0/1
01 = 1/1
1001 = 1/2
01101001 = 3/3
1001011001101001 = 5/6
01101001100101101001011001101001 = 11/11
1001011001101001011010011001011001101001100101101001011001101001 = 21/22
 */