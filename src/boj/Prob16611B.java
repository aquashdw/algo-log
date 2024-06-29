package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16611
public class Prob16611B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String lastWord = reader.readLine();
        String encrypted = reader.readLine();
        int lengthDiff = encrypted.length() - lastWord.length();

        char[] decrypted = new char[encrypted.length()];
        for (int i = 0; i < lastWord.length(); i++) {
            decrypted[lengthDiff + i] = lastWord.charAt(i);
        }
        int nextIdx = lengthDiff - 1;
        while (nextIdx >= 0) {
            int diff = encrypted.charAt(nextIdx + lastWord.length()) - decrypted[nextIdx + lastWord.length()];
            if (diff < 0) diff += 26;
            decrypted[nextIdx] = (char) ('a' + diff);
            nextIdx--;
        }
        System.out.println(new String(decrypted));
    }
}
