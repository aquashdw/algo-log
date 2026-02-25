package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13496
public class Prob13496 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 1; test < tests + 1; test++) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int ships = info[0];
            int speed = info[1];
            int days = info[2];
            int limit = speed * days;
            int total = 0;
            for (int i = 0; i < ships; i++) {
                int[] ship = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                if (ship[0] <= limit) total += ship[1];
            }
            answer.append(String.format("Data Set %d:%n", test));
            answer.append(total).append("\n\n");
        }
        System.out.print(answer);
    }
}
