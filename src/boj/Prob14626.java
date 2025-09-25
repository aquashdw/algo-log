package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14626
public class Prob14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String isbn = reader.readLine();
        boolean bias = false;
        int isbnSum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (isbn.charAt(i) == '*') {
                bias = i % 2 != 0;
                continue;
            }
            isbnSum += (isbn.charAt(i) - '0') * (i % 2 != 0 ? 3 : 1);
        }
        for (int i = 0; i < 10; i++) {
            if ((isbnSum + i * (bias ? 3 : 1)) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
