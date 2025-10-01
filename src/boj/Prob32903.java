package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32903
public class Prob32903 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[] record = new char[26];
        Arrays.fill(record, '.');
        reader.lines().limit(n)
                .mapToInt(line -> line.charAt(0) - 'a')
                .forEach(ch -> record[ch] = (char) (ch + 'a'));
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            answer.append(record[i]);
            if (i % 6 == 5) answer.append('\n');
        }
        System.out.println(answer);
    }
}
