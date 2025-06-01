package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/33571
public class Prob33571 {
    private static Set<Character> ones = Set.of('A', 'a', 'b', 'D', 'd', 'e', 'g', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', '@');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine().chars().map(c -> {
            if (c == 'B') return 2;
            if (ones.contains((char) c)) return 1;
            return 0;
        }).sum());
    }
}
