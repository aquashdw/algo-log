package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2765
public class Prob2765 {
    private static final double pi = 3.1415927;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int testCase = 0;
        while (true) {
            double[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            if (input[1] == 0.0) break;
            testCase++;
            double perimeter = pi * input[0];
            double distance = perimeter * input[1];
            double time = input[2];

            double distMiles = distance / 5280. / 12.;
            double mph = distMiles / (time / 3600);
            answer.append(String.format("Trip #%s: %.2f %.2f%n", testCase, distMiles, mph));
        }
        System.out.print(answer);
    }
}
