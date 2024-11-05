package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/18294
public class Prob18294 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String animal = reader.readLine();
            count.put(animal, count.getOrDefault(animal, 0) + 1);
            if (count.get(animal) > n / 2) {
                System.out.println(animal);
                return;
            }
        }
        System.out.println("NONE");
    }
}
