package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/18295
public class Prob18295 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<BigInteger> used = new HashSet<>();
        reader.lines().limit(n)
                .map(BigInteger::new)
                .filter(bi -> bi.compareTo(BigInteger.ZERO) >= 0)
                .forEach(used::add);

        BigInteger i = BigInteger.ZERO;
        while (true) {
            if (!used.contains(i)) {
                System.out.println(i);
                return;
            }
            i = i.add(BigInteger.ONE);
        }
    }
}
