package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/25276
public class Prob25276 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String wrong = reader.readLine();
        String right = reader.readLine();
        int lastRight = 0;
        while (lastRight < right.length() && lastRight < wrong.length() && wrong.charAt(lastRight) == right.charAt(lastRight)) {
            lastRight++;
        }
        System.out.println((wrong.length() - lastRight) + (right.length() - lastRight));
    }

}
