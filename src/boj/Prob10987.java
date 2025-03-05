package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10987
public class Prob10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine().chars()
                .filter(ch -> "aeiou".contains(String.valueOf((char) ch)))
                .count());
    }
}
