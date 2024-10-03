package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1254
public class Prob1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        int padding = word.length() - 1;
        for (int i = 0; i < word.length() - 1; i++) {
            int front = i;
            int back = word.length() - 1;
            while (front < back) {
                if (word.charAt(front) != word.charAt(back)) break;
                front++;
                back--;
            }
            if (!(front < back)) {
                padding = i;
                break;
            }
        }
        System.out.println(word.length() + padding);
    }
}
