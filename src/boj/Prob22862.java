package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/22862
public class Prob22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nk[0];
        int k = nk[1];
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int front = -1;
        int back = -1;
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                front = i;
                back = i;
                break;
            }
        }
        if (front == -1) {
            System.out.println(0);
            return;
        }
        int odds = 0;
        int evens = 0;
        int maxEvens = evens;
        while (back < n) {
            if (numbers[back] % 2 == 0) {
                evens++;
                maxEvens = Math.max(maxEvens, evens);
            }
            else odds++;

            while (odds > k) {
                if (numbers[front] % 2 == 0) evens--;
                else odds--;
                front++;
            }
            back++;
        }
        System.out.println(maxEvens);
    }
}
/*
9 2
2 2 2 2 2 3 3 2 3
 */