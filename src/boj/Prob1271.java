package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1271
public class Prob1271 {
    public static void main(String[] args) throws IOException {
        List<BigInteger> mn = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "))
                .map(BigInteger::new)
                .collect(Collectors.toList());
        System.out.printf("%s%n%s%n", mn.get(0).divide(mn.get(1)),  mn.get(0).remainder(mn.get(1)));
    }
}
