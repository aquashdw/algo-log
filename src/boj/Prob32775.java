package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/32775
public class Prob32775 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rail = Integer.parseInt(reader.readLine());
        int flight = Integer.parseInt(reader.readLine());
        System.out.println(rail <= flight ? "high speed rail" : "flight");
    }
}
