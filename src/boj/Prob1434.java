package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1434
public class Prob1434 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] boxes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] books = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int wasted = 0;
        int box = 0;
        for (int i = 0; i < nm[1]; i++) {
            while (boxes[box] < books[i]) {
                wasted += boxes[box];
                box++;
            }

            boxes[box] -= books[i];
        }

        while (box < nm[0]) {
            wasted += boxes[box];
            box++;
        }
        System.out.println(wasted);
    }
}
