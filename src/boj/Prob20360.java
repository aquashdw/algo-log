package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/20360
public class Prob20360 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String binStr = reader.lines().limit(1)
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::toBinaryString)
                .map(str -> (new StringBuilder(str)).reverse().toString())
                .reduce("", (a, b) -> b);

        List<String> idxList = new ArrayList<>();
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                idxList.add(String.valueOf(i));
            }
        }
        System.out.println(String.join(" ", idxList));
    }
}