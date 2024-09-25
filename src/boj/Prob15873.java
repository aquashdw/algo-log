package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15873
public class Prob15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.length() == 4) {
            System.out.println(20);
            return;
        }

        if (input.startsWith("10")) {
            System.out.println(input.charAt(2) - '0' + 10);
            return;
        }

        if (input.endsWith("10")) {
            System.out.println(input.charAt(0) - '0' + 10);
            return;
        }

        System.out.println(input.chars().map(i -> i - '0').sum());
    }
}
