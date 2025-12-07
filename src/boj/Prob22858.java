package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/22858
public class Prob22858 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int k = info[1];

        int[] deck = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] pattern = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).map(i -> i - 1).toArray();
        for (int i = 0; i < k; i++) {
            int[] newDeck = new int[n];
            for (int j = 0; j < n; j++) {
                newDeck[pattern[j]] = deck[j];
            }
            deck = newDeck;
        }

        System.out.println(Arrays.stream(deck).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
