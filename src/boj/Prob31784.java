package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/31784
public class Prob31784 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int swaps = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()[1];
        String start = reader.readLine();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < start.length() - 1; i++) {
            char letter = start.charAt(i);
            if (letter == 'A') {
                answer.append('A');
                continue;
            }
            // 'A' = 65, 'Z' = 90, 'Z' - 'A' = 25
            int diff = 'Z' - letter + 1;
            if (diff <= swaps) {
                swaps -= diff;
                answer.append('A');
            }
            else {
                answer.append(letter);
            }
        }
        int lastLetter = start.charAt(start.length() - 1);
        lastLetter -= 'A';
        lastLetter = (lastLetter + swaps) % 26 + 'A';
        answer.append((char) lastLetter);
        System.out.println(answer);
    }
}
/*
4 1000
XYZW

X -> A = 997
Y -> A = 995
Z -> A = 994
994 % 26 = 6
WXYZABC
2 25
ZB
 */