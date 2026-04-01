package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/21613
public class Prob21613 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maxVal = 0;
        String name = "";
        for (int i = 0; i < n; i++) {
            String next = reader.readLine();
            int nextVal = Integer.parseInt(reader.readLine());
            if (nextVal > maxVal) {
                maxVal = nextVal;
                name = next;
            }
        }
        System.out.print(name);
    }
}
