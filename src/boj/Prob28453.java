package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/28453
public class Prob28453 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(level -> {
                    if (level < 250) return "4";
                    if (level < 275) return "3";
                    if (level < 300) return "2";
                    if (level == 300) return "1";
                    return "-1";
                }).collect(Collectors.joining(" ")));
    }
}
