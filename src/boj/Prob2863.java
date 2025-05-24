package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2863
public class Prob2863 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[][] params = new double[2][];
        for (int i = 0; i < 2; i++) {
            params[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
        }

        double maxVal = 0;
        int maxSpin = 0;
        for (int i = 0; i < 4; i++) {
            double result = params[0][0] / params[1][0] + params[0][1] / params[1][1];
            if (result > maxVal) {
                maxVal = result;
                maxSpin = i;
            }

            double temp = params[0][0];
            params[0][0] = params[1][0];
            params[1][0] = params[1][1];
            params[1][1] = params[0][1];
            params[0][1] = temp;
        }

        System.out.println(maxSpin);
    }
}
