package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28691
public class Prob28691 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(switch (reader.readLine().charAt(0)) {
            case 'M' -> "MatKor";
            case 'W' -> "WiCys";
            case 'C' -> "CyKor";
            case 'A' -> "AlKor";
            case '$' -> "$clear";
            default -> throw new RuntimeException();
        });
    }
}
