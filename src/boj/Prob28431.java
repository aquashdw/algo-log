package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/28431
public class Prob28431 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> socks = new HashSet<>();
        reader.lines().limit(5).mapToInt(Integer::parseInt)
                .forEach(i -> {
                    if (socks.contains(i)) socks.remove(i);
                    else socks.add(i);
                });
        socks.forEach(System.out::println);
    }
}
