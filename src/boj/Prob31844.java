package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/31844
public class Prob31844 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String status = reader.readLine();
        String relative = status.chars()
                .filter(ch -> ch != '.')
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining(""));

        if (!relative.equals("@#!") && !relative.equals("!#@")) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.abs(status.indexOf('!') - status.indexOf('@')) - 1);
    }
}
