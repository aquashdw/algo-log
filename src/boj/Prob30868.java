package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/30868
public class Prob30868 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .mapToObj(votes -> {
                    String voteString = "++++ ".repeat(votes / 5) +
                            "|".repeat(votes % 5);
                    return voteString.strip();
                })
                .collect(Collectors.joining("\n")));
    }
}
