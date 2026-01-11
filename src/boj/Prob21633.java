package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/21633
public class Prob21633 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int transfer = Integer.parseInt(reader.readLine());
        double commission = 25;
        commission += (transfer / 100.);
        commission = Math.max(100, commission);
        commission = Math.min(2000, commission);
        System.out.printf("%.2f%n", commission);
    }

}
