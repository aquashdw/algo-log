package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/8437
public class Prob8437 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger apples = new BigInteger(reader.readLine());
        BigInteger klaudia = new BigInteger(reader.readLine());
        BigInteger half = apples.subtract(klaudia).divide(BigInteger.valueOf(2));
        System.out.println(String.valueOf(half.add(klaudia)) + '\n' + half);
    }
}
