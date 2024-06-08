package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30802
public class Prob30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(reader.readLine());
        int[] sizes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] packs = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int shirtPacks = Arrays.stream(sizes)
                .reduce(0, (total, now) -> total + (now / packs[0]) + (now % packs[0] == 0 ? 0 : 1));
        int penPacks = people / packs[1];
        int penSep = people % packs[1];
        System.out.printf("%d%n%d %d%n", shirtPacks, penPacks, penSep);
    }
}
