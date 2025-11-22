package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/13216
public class Prob13216 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String scores = reader.readLine();
        int aGames = 0;
        int bGames = 0;
        int i = 0;
        StringBuilder answer = new StringBuilder();
        while (aGames < 2 && bGames < 2) {
            int aScore = 0;
            int bScore = 0;
            while (!(aScore >= 21 || bScore >= 21)) {
                char score = scores.charAt(i);
                i++;
                if (score == 'A') aScore++;
                else bScore++;
            }
            answer.append(String.format("%d-%d%n", aScore, bScore));
            if (aScore > bScore) aGames++;
            else bGames++;
        }
        if (aGames > bGames) answer.append('A');
        else answer.append('B');
        System.out.println(answer);
    }
}
