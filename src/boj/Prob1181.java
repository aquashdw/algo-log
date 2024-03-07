package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1181 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().skip(1)
                .sorted((o1, o2) -> {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else return o1.length() - o2.length();
                })
                .distinct()
                .forEach(line -> answer.append(line).append('\n'));
        System.out.println(answer);
    }
}
