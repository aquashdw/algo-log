package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/10808
public class Prob10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] alphas = new int[26];
        reader.readLine().chars().forEach(c -> alphas[c - 'a']++);
        System.out.println(Arrays.stream(alphas)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" ")));
    }
}
