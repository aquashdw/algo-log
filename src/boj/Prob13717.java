package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13717
public class Prob13717 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int totalEvolve = 0;
        int maxEvolve = -1;
        String maxEvolvedName = "";
        for (int i = 0; i < n; i++) {
            String pokemon = reader.readLine();
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int req = info[0];
            int candies = info[1];
            int evolves = 0;
            while (candies >= req) {
                int count = candies / req;
                evolves += count;
                candies -= count * req;
                candies += count * 2;
            }

            totalEvolve += evolves;
            if (evolves > maxEvolve) {
                maxEvolve = evolves;
                maxEvolvedName = pokemon;
            }
        }
        System.out.printf("%d%n%s%n", totalEvolve, maxEvolvedName);
    }
}
