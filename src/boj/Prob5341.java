package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5341
public class Prob5341 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            answer.append(n * (n + 1) / 2).append('\n');
        }
        System.out.print(answer);
    }
}
