package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16438
public class Prob16438 {
    private static char[][] rounds;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int monkeys = Integer.parseInt(reader.readLine());
        rounds = new char[7][monkeys];
        dnc(0, monkeys, 0);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 7; i++) {

            answer.append(new String(rounds[i])).append('\n');
        }
        System.out.print(answer);
    }

    private static void dnc(int start, int end, int level) {
        if (level == 7) return;
        if (end - start <= 1) {
            for (int i = level; i < 7; i++) {
                rounds[i][start] = rounds[i - 1][start];
            }
            return;
        }
        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            rounds[level][i] = 'A';
        }
        for (int i = mid; i < end; i++) {
            rounds[level][i] = 'B';
        }
        dnc(start, mid, level + 1);
        dnc(mid, end, level + 1);
    }
}
