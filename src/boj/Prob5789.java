package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/5789
public class Prob5789 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(n).map(line -> {
            int mid = line.length() / 2;
            char l = line.charAt(mid - 1);
            char r = line.charAt(mid);
            return l == r ? "Do-it" : "Do-it-Not";
        }).collect(Collectors.joining("\n")));
    }
}
