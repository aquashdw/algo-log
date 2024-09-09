package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

// https://www.acmicpc.net/problem/10827
public class Prob10827 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        BigDecimal base = BigDecimal.valueOf(Double.parseDouble(tokens[0]));
        int exponent = Integer.parseInt(tokens[1]);
        System.out.println(base.pow(exponent).toPlainString());
    }
}
