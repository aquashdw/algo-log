package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/8387
public class Prob8387 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String origin = reader.readLine();
        String test = reader.readLine();
        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == test.charAt(i)) count++;
        }
        System.out.println(count);
    }
}
