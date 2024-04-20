package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4101
public class Prob4101 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0 0")) {
            int[] ab = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            answer.append(ab[0] > ab[1] ? "Yes\n" : "No\n");
        }
        System.out.print(answer);
    }
}

