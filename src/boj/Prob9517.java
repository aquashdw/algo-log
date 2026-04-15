package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9517
public class Prob9517 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int queries = Integer.parseInt(reader.readLine());
        int timeLeft = 210;
        while (queries-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            timeLeft -= Integer.parseInt(tokens[0]);
            if (timeLeft <= 0) break;
            if (tokens[1].equals("T")) start++;
            if (start > 8) start -= 8;
        }
        System.out.println(start);
    }
}
