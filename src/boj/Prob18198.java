package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/18198
public class Prob18198 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String game = reader.readLine();
        int aScore = 0;
        int bScore = 0;
        int nextChar = 0;
        while (nextChar < game.length()) {
            char player = game.charAt(nextChar);
            nextChar++;
            int score = game.charAt(nextChar) - '0';
            nextChar++;
            if (player == 'A')
                aScore += score;
            if (player == 'B')
                bScore += score;
        }
        System.out.println(aScore > bScore ? 'A' : 'B');
    }
}
