package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/5666
public class Prob5666 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().map(line -> {
            double[] hotDogs = Arrays.stream(line.split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            double avg = hotDogs[0] / hotDogs[1];
            return String.format("%.2f", avg);
        }).collect(Collectors.joining("\n")));
    }
}
