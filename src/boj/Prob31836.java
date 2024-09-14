package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/31836
public class Prob31836 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n == 2) {
            System.out.println("1\n1\n1\n2");
            return;
        }
        List<Integer> aPresents = new ArrayList<>();
        List<Integer> bPresents = new ArrayList<>();
        while (n > 2) {
            aPresents.add(n--);
            bPresents.add(n--);
            bPresents.add(n--);
        }
        if (n == 2) {
            aPresents.add(2);
            bPresents.add(1);
        }

        StringBuilder answer = new StringBuilder();
        answer.append(aPresents.size()).append('\n');
        answer.append(aPresents.stream().map(String::valueOf).collect(Collectors.joining(" "))).append('\n');
        answer.append(bPresents.size()).append('\n');
        answer.append(bPresents.stream().map(String::valueOf).collect(Collectors.joining(" "))).append('\n');
        System.out.print(answer);
    }
}
