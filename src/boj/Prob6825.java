package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6825
public class Prob6825 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        double bmi = weight / (height * height);
        if (bmi > 25) {
            System.out.println("Overweight");
        }
        else if (bmi >= 18.5) {
            System.out.println("Normal weight");
        }
        else {
            System.out.println("Underweight");
        }
    }
}
