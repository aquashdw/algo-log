package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/31495
public class Prob31495 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line.length() <= 2) {
            System.out.println("CE");
            return;
        } else if (!(line.startsWith("\"") && line.endsWith("\""))) {
            System.out.println("CE");
            return;
        }
        System.out.println(line.substring(1, line.length() - 1));
    }
}
