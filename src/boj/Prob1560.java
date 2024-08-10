package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/1560
public class Prob1560 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(reader.readLine());
        if (n.compareTo(BigInteger.TWO) <= 0) System.out.println(n);
        else System.out.println(n.multiply(BigInteger.TWO).subtract(BigInteger.TWO));
    }
}

