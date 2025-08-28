package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30875
public class Prob30875 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int area = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
//            int[] rowInt = new int[n];
//            Arrays.fill(rowInt, area);
            String[] rowInt = new String[n];
            Arrays.fill(rowInt, String.valueOf(area + 1));
            answer.append(String.join(" ", rowInt));
            answer.append('\n');
            area = (area + 1) % 2;
        }
        System.out.print(answer);
    }
}

