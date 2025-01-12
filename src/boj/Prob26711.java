package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/26711
public class Prob26711 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(2).map(BigInteger::new).reduce(BigInteger::add).ifPresent(System.out::println);
    }
}
