package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/17588
public class Prob17588 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        List<Integer> out = new ArrayList<>();
        int next = 1;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            int chime = Integer.parseInt(line);
            while (chime > next) {
                out.add(next);
                next++;
            }
            next++;
        }
        if (out.isEmpty()) {
            System.out.println("good job");
            return;
        }
        out.forEach(i -> answer.append(i).append('\n'));
        System.out.print(answer);
    }
}
