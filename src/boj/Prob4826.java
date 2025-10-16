package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4826
public class Prob4826 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        double meter = 0;
        double lastFuel = 0;
        double totalDist = 0;
        double totalFuel = 0;
        int n = 0;
        while (!(line = reader.readLine()).strip().equals("-1.0 -1.0")) {
            if (line.equals("0.0 0.0")) {
                n++;
                double left = lastFuel * (totalDist / totalFuel);
                answer.append(Math.round(left)).append('\n');
                totalDist = 0;
                totalFuel = 0;
                meter = 0;
                lastFuel = 0;

                continue;
            }
            double[] info = Arrays.stream(line.split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            if (meter == 0) {
                meter = info[0];
                lastFuel = info[1];
                continue;
            }

            if (lastFuel > info[1]) {
                totalDist += info[0] - meter;
                totalFuel += lastFuel - info[1];
            }
            meter = info[0];
            lastFuel = info[1];
        }
        System.out.print(answer);
    }

}
