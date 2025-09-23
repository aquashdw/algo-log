package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/11531
public class Prob11531 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<Character, Integer> fails = new HashMap<>();
        Map<Character, Integer> rightTime = new HashMap<>();
        while (!(line = reader.readLine()).equals("-1")) {
            String[] tokens = line.split(" ");
            int time = Integer.parseInt(tokens[0]);
            char prob = tokens[1].charAt(0);
            boolean right = tokens[2].equals("right");
            if (right) {
                rightTime.put(prob, time);
            } else {
                fails.putIfAbsent(prob, 0);
                fails.put(prob, fails.get(prob) + 1);
            }
        }
        int penalty = 0;
        for (char prob : rightTime.keySet()) {
            penalty += rightTime.get(prob);
            penalty += fails.getOrDefault(prob, 0) * 20;
        }
        System.out.printf("%d %d%n", rightTime.size(), penalty);
    }
}
