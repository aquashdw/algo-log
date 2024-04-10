package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/1264
public class Prob1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder answer = new StringBuilder();
        reader.lines().filter(line -> !line.equals("#")).forEach(line -> answer.append(line.chars()
                .filter(i -> vowels.contains((char) i))
                .count())
                .append('\n'));
        System.out.print(answer);
    }
}
