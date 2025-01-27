package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6764
public class Prob6764 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] depths = reader.lines().limit(4).mapToInt(Integer::parseInt).toArray();
        if (depths[0] == depths[1] && depths[1] == depths[2] && depths[2] == depths[3]) {
            System.out.println("Fish At Constant Depth");
        }
        else if (depths[0] < depths[1] && depths[1] < depths[2] && depths[2] < depths[3]) {
            System.out.println("Fish Rising");
        }
        else if (depths[0] > depths[1] && depths[1] > depths[2] && depths[2] > depths[3]) {
            System.out.println("Fish Diving");
        }
        else System.out.println("No Fish");
    }
}
