package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/33651
public class Prob33651 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String origin = "UAPC";
        Set<Character> removed = reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        StringBuilder answer = new StringBuilder();
        for (char c : origin.toCharArray()) {
            if (removed.contains(c)) continue;
            answer.append(c);
        }
        System.out.println(answer);
    }
}
