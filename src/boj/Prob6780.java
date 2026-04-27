package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6780
public class Prob6780 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 2;
        int front = Integer.parseInt(reader.readLine());
        int back = Integer.parseInt(reader.readLine());
        int diff;
        while ((diff = Math.abs(front - back)) <= back) {
            count++;
            front = back;
            back = diff;
        }
        System.out.println(count + 1);
    }
}
