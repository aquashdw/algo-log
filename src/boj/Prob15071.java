package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15071
public class Prob15071 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cipher = reader.readLine();
        String key = reader.readLine();
        StringBuilder message = new StringBuilder();
        int i;
        for (i = 0; i < key.length() && i < cipher.length(); i++) {
            int origin = cipher.charAt(i) - key.charAt(i) + 'A';
            if (origin < 'A') origin += 26;
            message.append((char) origin);
        }

        for (; i < cipher.length(); i++) {
            int origin = cipher.charAt(i) - message.charAt(i - key.length()) + 'A';
            if (origin < 'A') origin += 26;
            message.append((char) origin);
        }
        System.out.println(message);
    }
}
