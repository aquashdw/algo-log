package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/11651
public class Prob11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        reader.lines().limit(n).sorted(
                (line1, line2) -> {
                    int[] xy1 = Arrays.stream(line1.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int[] xy2 = Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).toArray();
                    if (xy1[1] == xy2[1]) return xy1[0] - xy2[0];
                    else return xy1[1] - xy2[1];
                }
        ).forEach(i -> answer.append(i).append('\n'));
        System.out.print(answer);
    }
}
