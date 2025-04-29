package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2921
public class Prob2921 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                count += i + j;
            }
        }
        System.out.println(count);
    }
}
/*
0 0
0 1
0 2
0 3
1 1
1 2
1 3
2 2
2 3
3 3
1 2 3 1 1 1 2 1 3 2 2 2 3 3 3
30
 */
