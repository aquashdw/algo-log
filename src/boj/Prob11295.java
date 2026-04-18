package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11295
public class Prob11295 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = 1;
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0")) {
            answer.append(String.format("User %d%n", test));
            int stride = Integer.parseInt(line.strip());
            int n = Integer.parseInt(reader.readLine().strip());
            for (int i = 0; i < n; i++) {
                int steps = Integer.parseInt(reader.readLine().strip());
                int centimeters = steps * stride;
                answer.append(String.format("%.5f%n", centimeters / 100000.0));
            }
            test++;
        }
        System.out.print(answer);
    }
}
