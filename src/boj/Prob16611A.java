package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16611
public class Prob16611A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String lastWord = reader.readLine();
        String encrypted = reader.readLine();
        char[] newWord = new char[lastWord.length()];

        char[] decrypted = new char[encrypted.length()];
        for (int i = 0; i < lastWord.length(); i++) {
            decrypted[encrypted.length() - lastWord.length() + i] = lastWord.charAt(i);
        }

        int wordIdx = 0;
        for (int i = 0; i < encrypted.length() - lastWord.length(); i++) {
            int diff = encrypted.charAt(encrypted.length() - (i + 1)) - lastWord.charAt(lastWord.length() - (wordIdx + 1));
            if (diff < 0) diff += 26;
            decrypted[encrypted.length() - (i + 1) - lastWord.length()] = (char) (diff + 'a');

            newWord[lastWord.length() - (wordIdx + 1)] = (char) (diff + 'a');
            wordIdx++;
            if (wordIdx == lastWord.length()) {
                wordIdx = 0;
                lastWord = new String(newWord);
            }
        }
        System.out.println(new String(decrypted));
    }
}
