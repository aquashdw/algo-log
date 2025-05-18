package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6888
public class Prob6888 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (x <= y) {
            answer.append("All positions change in year ").append(x).append('\n');
            x += 60;
        }
        System.out.print(answer);
    }
}
