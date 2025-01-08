package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/21885
public class Prob21885 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nksx = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = nksx[0];
        int k = nksx[1];
        int s = nksx[2];
        int x = nksx[3];

        boolean[] visited = new boolean[n];
        int now = s;
        int answer = 0;
        while (!visited[now]) {
            visited[now] = true;
            if (now == x) break;
            answer++;
            now += k;
            now %= n;
        }
        System.out.println(visited[x] ? answer : -1);
    }
}
