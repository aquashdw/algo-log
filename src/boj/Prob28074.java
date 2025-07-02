package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/28074
public class Prob28074 {
    private static final Set<Character> mobis = Set.of('M', 'O', 'B', 'I', 'S');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine().chars()
                .distinct()
                .filter(i -> mobis.contains((char) i))
                .count() == 5 ? "YES" : "NO");
    }
}
