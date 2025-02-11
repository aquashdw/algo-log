package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/20492
public class Prob20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int prize = Integer.parseInt(reader.readLine());
        int allTaxed = prize / 100;
        allTaxed *= 78;
        int someTaxed = prize / 1000;
        someTaxed *= 956;
        System.out.printf("%d %d%n", allTaxed, someTaxed);
    }
}
