package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/2338
public class Prob2338 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(reader.readLine());
        BigInteger b = new BigInteger(reader.readLine());
        BigInteger sum = a.add(b);
        BigInteger diff = a.subtract(b);
        BigInteger product = a.multiply(b);
        System.out.printf("%s%n%s%n%s%n", sum, diff, product);
    }

}
