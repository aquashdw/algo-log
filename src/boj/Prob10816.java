package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


// https://www.acmicpc.net/problem/10816
public class Prob10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> cardCount = new HashMap<>();
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(card -> cardCount.put(card, cardCount.getOrDefault(card, 0) + 1));

        int m = Integer.parseInt(reader.readLine());
        String answer = Arrays.stream(reader.readLine().split(" "))
                .map(card -> String.valueOf(cardCount.getOrDefault(Integer.parseInt(card), 0)))
                .collect(Collectors.joining(" "));
        System.out.println(answer);
    }
}
