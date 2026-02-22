package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/9772
public class Prob9772 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(reader.lines().takeWhile(line -> !line.equals("0 0"))
                .map(line -> {
                    int[] signs = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble)
                            .mapToInt(d -> d == 0 ? 0 : (d > 0 ? 1 : -1))
                            .toArray();
                    if (signs[0] * signs[1] == 0) {
                        return "AXIS";
                    } else if (signs[0] * signs[1] > 0) {
                        if (signs[0] > 0) return "Q1";
                        else return "Q3";
                    } else {
                        if (signs[0] < 0) return "Q2";
                        else return "Q4";
                    }
                }).collect(Collectors.joining("\n")) + "\nAXIS");
    }
}
