package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/21873
public class Prob21873 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        int frog = 1;
        int move = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                answer.append(String.format("%d %d%n", frog, j));
                move++;
            }
            frog++;
            if (frog > 2) frog = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            answer.append(String.format("%d %d%n", frog, i));
            move++;
        }

        for (int i = 1; i < n + 1; i++) {
            frog++;
            if (frog > 2) frog = 1;
            for (int j = i; j < n + 1; j++) {
                answer.append(String.format("%d %d%n", frog, j));
                move++;
            }
        }
        System.out.println(move);
        System.out.print(answer);
    }

}
/*
11022
10122
12102
12120
12021
02121
20121
22101
22011


111102222
111012222
111212022
101212122
121212120
021212121
 */