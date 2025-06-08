package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20499
public class Prob20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] kda = Arrays.stream(reader.readLine().split("/"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(kda[0] + kda[2] < kda[1] || kda[1] == 0 ? "hasu" : "gosu");
    }
}
