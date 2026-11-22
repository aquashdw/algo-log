package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://acmicpc.net/problem/1919
public class Prob1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[26];
        reader.readLine().chars().forEach(ch -> counts[ch - 'a']++);
        reader.readLine().chars().forEach(ch -> counts[ch - 'a']--);
        System.out.println(Arrays.stream(counts).filter(i -> i != 0).map(Math::abs).sum());
    }
}
