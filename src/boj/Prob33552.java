package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/33552
public class Prob33552 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int leftWeight = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        double totalScore = 0;
        int otherWeight = 0;
        for (int i = 0; i < n; i++) {
            String[] gradeWeights = reader.readLine().split(" ");
            double grade = Double.parseDouble(gradeWeights[0]);
            if (grade < 5.8) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            int weight = Integer.parseInt(gradeWeights[1]);
            totalScore += grade * weight;
            otherWeight += weight;
        }

        double cumLaude = (leftWeight + otherWeight) * 8.0;
        double requiredScore = (cumLaude - totalScore) / leftWeight;
        requiredScore = Math.ceil(requiredScore * 10) / 10.;
        if (requiredScore > 10) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        if (requiredScore < 5.8) {
            System.out.println(5.8);
            return;
        }
        System.out.println(requiredScore);
    }
}

