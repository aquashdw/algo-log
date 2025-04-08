package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6131
public class Prob6131 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 1; i < 500; i++) {
            for (int j = i + 1; j < 501; j++) {
                count += j * j - i * i == n ? 1 : 0;
            }
        }
        System.out.println(count);
    }
}
