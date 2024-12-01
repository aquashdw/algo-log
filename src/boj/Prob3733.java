package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3733
public class Prob3733 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            int[] ns = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            answer.append(ns[1] / (ns[0] + 1)).append('\n');
        }
        System.out.print(answer);
    }
}
