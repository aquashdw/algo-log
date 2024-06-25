package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5358
public class Prob5358 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().forEach(line -> {
            char[] chars = new char[line.length()];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = line.charAt(i);
                if (chars[i] == 'i') chars[i] = 'e';
                else if (chars[i] == 'I') chars[i] = 'E';
                else if (chars[i] == 'e') chars[i] = 'i';
                else if (chars[i] == 'E') chars[i] = 'I';
            }
            answer.append(new String(chars)).append('\n');
        });
        System.out.print(answer);
    }

}
