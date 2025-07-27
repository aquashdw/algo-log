package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/20233
public class Prob20233 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int aMonthly = Integer.parseInt(reader.readLine());
        int aMin = Integer.parseInt(reader.readLine());
        int bMonthly = Integer.parseInt(reader.readLine());
        int bMin = Integer.parseInt(reader.readLine());
        int minADay = Integer.parseInt(reader.readLine());

        aMonthly += Math.max(minADay - 30, 0) * aMin * 21;
        bMonthly += Math.max(minADay - 45, 0) * bMin * 21;
        System.out.printf("%d %d%n", aMonthly, bMonthly);
    }
}
