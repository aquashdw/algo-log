package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/8558
public class Prob8558 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(switch (n) {
            case 0, 1 -> 1;
            case 2, 4 -> n;
            case 3 -> 6;
            default -> 0;
        });
    }
}
