package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11609
public class Prob11609 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).sorted((n1, n2) -> {
            String[] name1 = n1.split(" ");
            String[] name2 = n2.split(" ");
            return name1[1].compareTo(name2[1]) == 0 ? name1[0].compareTo(name2[0]) : name1[1].compareTo(name2[1]);
        }).forEach(name -> answer.append(name).append('\n'));
        System.out.print(answer);
    }
}
