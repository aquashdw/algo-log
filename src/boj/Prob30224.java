package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/30224
public class Prob30224 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int num = Integer.parseInt(number);
        if (number.contains("7") && num % 7 == 0) {
            System.out.println(3);
        } else if (number.contains("7")) {
            System.out.println(2);
        } else if (num % 7 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
