package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1100
public class Prob1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String line = reader.readLine();
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) continue;
                if (line.charAt(j) == 'F') count++;
            }
        }
        System.out.println(count);
    }
}
