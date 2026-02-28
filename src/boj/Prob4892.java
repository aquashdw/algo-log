package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4892
public class Prob4892 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int test = 1;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0")) {
            int number = Integer.parseInt(line);
            int n1 = 3 * number;
            int n2 = (n1 + n1 % 2) / 2;
            int n3 = 3 * n2;
            int n4 = n3 / 9;
            answer.append(String.format("%d. %s %d%n", test, n1 % 2 == 0 ? "even" : "odd", n4));
            test++;
        }
        System.out.print(answer);
    }
}
