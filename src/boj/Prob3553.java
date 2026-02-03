package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/3553
public class Prob3553 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        BigInteger d = new BigInteger(tokens[1]);

        BigInteger base = BigInteger.ONE;
        for (int i = 0; i < n - 1; i++) {
            base = base.multiply(BigInteger.valueOf(10));
        }

        BigInteger mod = base.mod(d);
        if (mod.compareTo(BigInteger.ZERO) > 0) {
            BigInteger flatten = d.subtract(mod);
            base = base.add(flatten);
        }

        System.out.println(String.valueOf(base).length() == n ? base : "No solution");
    }
}
