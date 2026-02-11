package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5343
public class Prob5343 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).forEach(line -> {
            int errors = 0;
            int start = 0;
            while (start < line.length()) {
                long posBits = line.chars()
                        .skip(start)
                        .limit(7)
                        .filter(ch -> ch == '1')
                        .count();
                if (posBits % 2 != line.charAt(start + 7) - '0') errors++;
                start += 8;
            }
            answer.append(errors).append('\n');
        });
        System.out.print(answer);
    }
}
