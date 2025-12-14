package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// https://www.acmicpc.net/problem/6830
public class Prob6830 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(Objects::nonNull)
                .map(line -> line.split(" "))
                .reduce(new String[]{"Nowhere", "201"}, (prev, now) -> {
                    int prevTemp = Integer.parseInt(prev[1]);
                    int nowTemp = Integer.parseInt(now[1]);
                    return prevTemp < nowTemp ? prev : now;
                })[0]);
    }
}
