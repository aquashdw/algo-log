package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1547
public class Prob1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int moves = Integer.parseInt(reader.readLine());
        boolean[] ball = {true, false, false};
        reader.lines().limit(moves).map(line -> Arrays.stream(line.split(" "))
                .mapToInt(c -> Integer.parseInt(c) - 1)
                .toArray()).forEach(move -> {
                    if (ball[move[0]] || ball[move[1]]) {
                        ball[move[0]] = !ball[move[0]];
                        ball[move[1]] = !ball[move[1]];
                    }
        });
        for (int i = 0; i < 3; i++) {
            if (ball[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }

}
