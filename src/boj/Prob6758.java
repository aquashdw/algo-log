package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/6750
public class Prob6758 {
    private static final Set<Character> letters = Set.of('I', 'O', 'S', 'H', 'Z', 'X', 'N');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine()
                .chars()
                .allMatch(ch -> letters.contains((char) ch)) ? "YES" : "NO");
    }
}
