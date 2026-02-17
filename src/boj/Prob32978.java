package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/32978
public class Prob32978 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> ingredients = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toSet());
        Set<String> used = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toSet());
        ingredients.removeAll(used);
        ingredients.forEach(System.out::println);
    }
}
