package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/27434
public class Prob27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(fact(1, n));
    }

    private static BigInteger fact(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            return fact(low, mid).multiply(fact(mid + 1, high));
        }
        return BigInteger.valueOf(low);
    }
}
