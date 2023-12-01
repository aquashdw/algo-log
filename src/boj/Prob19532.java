package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob19532 {
    public String solution() throws IOException {
        StringTokenizer input =
                new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int a = Integer.parseInt(input.nextToken());
        int b = Integer.parseInt(input.nextToken());
        int c = Integer.parseInt(input.nextToken());
        int d = Integer.parseInt(input.nextToken());
        int e = Integer.parseInt(input.nextToken());
        int f = Integer.parseInt(input.nextToken());

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (a * i + b * j == c && d * i + e * j == f)
                    return i + " " + j;
            }
        }
        return "0 0";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob19532().solution());
    }
}
