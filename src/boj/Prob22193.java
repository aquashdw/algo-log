package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/22193
public class Prob22193 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().skip(1).limit(2)
                .map(BigInteger::new)
                .reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
