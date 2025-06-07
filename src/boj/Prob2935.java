package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/2935
public class Prob2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(reader.readLine());
        char operator = reader.readLine().charAt(0);
        BigInteger b = new BigInteger(reader.readLine());
        System.out.println(switch (operator) {
            case '+' -> a.add(b);
            case '*' -> a.multiply(b);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        });
    }
}
