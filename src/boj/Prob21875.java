package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/21875
public class Prob21875 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String start = reader.readLine();
        String end = reader.readLine();
        int chDiff = Math.abs(start.charAt(0) - end.charAt(0));
        int diDiff = Math.abs(start.charAt(1) - end.charAt(1));
        System.out.printf("%d %d%n", Math.min(chDiff, diDiff), Math.max(chDiff, diDiff));
    }
}
