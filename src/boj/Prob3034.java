package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3034
public class Prob3034 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int width = info[1];
        int height = info[2];
        int diagonal = width * width + height * height;
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).mapToInt(Integer::parseInt)
                .map(i -> i * i)
                .forEach(i -> answer.append(i <= diagonal ? "DA\n" : "NE\n"));
        System.out.print(answer);
    }
}
