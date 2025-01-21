package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5543
public class Prob5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int price = reader.lines().limit(3)
                .mapToInt(Integer::parseInt)
                .min()
                .orElseThrow();
        price += reader.lines().limit(2)
                .mapToInt(Integer::parseInt)
                .min()
                .orElseThrow();
        price -= 50;
        System.out.println(price);
    }
}
