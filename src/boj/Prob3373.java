package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/3373
public class Prob3373 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(reader.readLine());
        int[][] cards = new int[cardCount][3];
        for (int i = 0; i < cardCount; i++) {
            int[] card = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int small = Math.min(card[0], card[1]);
            int large = Math.max(card[0], card[1]);
            cards[i][0] = small;
            cards[i][1] = large;
            cards[i][2] = small + large;
        }

        Arrays.sort(cards, Comparator.comparingInt(o -> o[2]));

        int sum = 0;
        for (int i = 0; i < cardCount / 2; i++) {
            sum += cards[i][0] - cards[cardCount / 2 + i][1];
        }

        System.out.println(sum);
    }
}
