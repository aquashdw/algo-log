package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/18330
public class Prob18330 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(reader.readLine());
        int left = Integer.parseInt(reader.readLine()) + 60;
        if (total <= left) {
            System.out.println(total * 1500);
            return;
        }

        int cost = left * 1500;
        total -= left;
        cost += total * 3000;
        System.out.println(cost);
    }
}
