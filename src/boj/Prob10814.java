package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;


// https://www.acmicpc.net/problem/10814
public class Prob10814 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        new BufferedReader(new InputStreamReader(System.in)).lines()
                .skip(1)
                .map(line -> line.split(" "))
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o[0])))
                .forEach(info -> answer
                        .append(info[0])
                        .append(" ")
                        .append(info[1])
                        .append('\n'));
        System.out.print(answer);
    }
}
