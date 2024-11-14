package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18008
public class Prob18008 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] letterCount = new int[26];
        reader.readLine().chars()
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .forEach(c -> letterCount[c - 'A']++);

        int totalLength = (Arrays.stream(letterCount).sum() - 1) * 3;
        int[] symbolLengths = new int[12];
        symbolLengths[1] = 1;
        symbolLengths[3] = 2;
        for (int i = 5; i < 12; i++) {
            if (i % 2 == 0) continue;
            symbolLengths[i] = symbolLengths[i - 2] + symbolLengths[i - 4];
        }

        int[] mostLetters = Arrays.stream(letterCount).filter(i -> i != 0)
                .map(i -> -i)
                .sorted()
                .map(i -> -i)
                .toArray();

        int nextSymLength = 0;
        for (int mostLetter : mostLetters) {
            while (symbolLengths[nextSymLength] == 0) nextSymLength++;
            symbolLengths[nextSymLength]--;
            totalLength += nextSymLength * mostLetter;
        }

        System.out.println(totalLength);
    }
}
/*
1-1: .
3-2: .. -
5-3: ... -. .-
7-5: .... -.. .-. ..- --
9-8: ..... -... .-.. ..-. ...- --. -.- .--
11-13 : ......
-.... .-... ..-.. ...-. ....-
--.. -.-. -..- .--. .-.- ..--
---
 */
