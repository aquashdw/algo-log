package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27918
public class Prob27918 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int d = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line.equals("D")) d++;
            else if (line.equals("P")) p++;
            if (Math.abs(d - p) >= 2) break;
        }
        System.out.printf("%d:%d%n", d, p);
    }
}
