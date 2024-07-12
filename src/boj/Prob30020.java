package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30020
public class Prob30020 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] cheeseAndPatties = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int patties = cheeseAndPatties[0];
        int cheese = cheeseAndPatties[1];
        if (cheese >= patties) {
            System.out.println("NO");
            return;
        }
        int burgers = patties - cheese;
        if (cheese < burgers) {
            System.out.println("NO");
            return;
        }
        StringBuilder answer = new StringBuilder();
        answer.append("YES\n");
        answer.append(burgers).append('\n');
        while (patties - cheese > 1) {
            answer.append("aba\n");
            patties -= 2;
            cheese--;
        }

        answer.append("ab".repeat(cheese)).append('a');
        System.out.println(answer);
    }
}
