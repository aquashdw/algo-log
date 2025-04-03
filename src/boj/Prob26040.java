package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26040
public class Prob26040 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (b.contains(String.valueOf(a.charAt(i)))) {
                c.append(Character.toLowerCase(a.charAt(i)));
            } else c.append(a.charAt(i));
        }
        System.out.println(c);
    }
}
