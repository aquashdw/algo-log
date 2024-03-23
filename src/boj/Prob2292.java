package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/2292
public class Prob2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()) - 1;
        int count = 1;
        while (n > 0) {
            n -= count * 6;
            count += 1;
        }

        System.out.println(count);
    }
}
