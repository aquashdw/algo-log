package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/3449
public class Prob3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String a = reader.readLine();
            String b = reader.readLine();
            answer.append("Hamming distance is ")
                    .append(IntStream.range(0, a.length())
                            .filter(j -> a.charAt(j) != b.charAt(j))
                            .count())
                    .append(".\n");
        }
        System.out.print(answer);
    }
}
