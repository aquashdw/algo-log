package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/9375
public class Prob9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            int n = Integer.parseInt(reader.readLine());
            for (int j = 0; j < n; j++) {
                String[] cloth = reader.readLine().split(" ");
                clothes.put(cloth[1], clothes.getOrDefault(cloth[1], 0) + 1);
            }
            int combs = 1;
            for (int kinds: clothes.values()) {
                combs *= kinds + 1;
            }
            answer.append(combs - 1).append('\n');
        }
        System.out.print(answer);
    }
}
