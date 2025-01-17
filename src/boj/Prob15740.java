package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15740
public class Prob15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .map(BigInteger::new).reduce(BigInteger.ZERO, BigInteger::add));
    }
}
