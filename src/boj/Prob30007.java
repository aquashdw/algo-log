package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30007
public class Prob30007 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).forEach(line -> {
            int[] data = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            answer.append(data[0] * (data[2] - 1) + data[1]).append('\n');
        });
        System.out.print(answer);
    }
}
