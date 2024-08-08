package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9850
public class Prob9850 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String live = "LIVE";
        String chipmunks = "CHIPMUNKS";
        String cypher = reader.readLine();
        StringBuilder letters = new StringBuilder();
        cypher.chars().filter(c -> Character.isAlphabetic(c) || c == ' ').forEach(c -> letters.append((char) c));

        String[] words = letters.toString().split(" ");
        int key = -1;
        for (String word : words) {
            if (word.length() != live.length() && word.length() != chipmunks.length()) continue;
            if (word.length() == live.length()) {
                int initDiff = word.charAt(0) - live.charAt(0);
                if (initDiff < 0) initDiff += 26;
                boolean success = true;
                for (int i = 1; i < live.length(); i++) {
                    int charDiff = word.charAt(i) - live.charAt(i);
                    if (charDiff < 0) charDiff += 26;
                    if (initDiff != charDiff) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    key = initDiff;
                }
            }
            else if (word.length() == chipmunks.length()) {
                int initDiff = word.charAt(0) - chipmunks.charAt(0);
                if (initDiff < 0) initDiff += 26;
                boolean success = true;
                for (int i = 1; i < chipmunks.length(); i++) {
                    int charDiff = word.charAt(i) - chipmunks.charAt(i);
                    if (charDiff < 0) charDiff += 26;
                    if (initDiff != charDiff) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    key = initDiff;
                }
            }

            if (key != -1) break;
        }

        int finalKey = key;
        StringBuilder answer = new StringBuilder();
        cypher.chars().forEach(c -> {
            if (Character.isAlphabetic(c)) {
                c -= finalKey;
                if (c < 'A') c += 26;
                answer.append((char) c);
            }
            else answer.append((char) c);
        });
        System.out.println(answer);
    }
}
