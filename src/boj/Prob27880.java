package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27880
public class Prob27880 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().limit(4).mapToInt(line -> {
            String[] info = line.split(" ");
            int steps = Integer.parseInt(info[1]);
            if (info[0].equals("Es")) return 21 * steps;
            else return 17 * steps;
        }).sum());
    }
}
