package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26489
public class Prob26489 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            count++;
        }
        System.out.println(count);
    }
}
