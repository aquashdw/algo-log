package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/11050
public class Prob11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int points = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(points)
                .sorted((line1, line2) -> {
                    int[] xy1 = Arrays.stream(line1.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    int[] xy2 = Arrays.stream(line2.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    if (xy1[0] == xy2[0])
                        return xy1[1] - xy2[1];
                    else return xy1[0] - xy2[0];
                })
                .forEach(line -> answer.append(line).append('\n'));
        System.out.print(answer);
    }
}
