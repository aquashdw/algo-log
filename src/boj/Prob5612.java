package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5612
public class Prob5612 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int cars = Integer.parseInt(reader.readLine());
        int maxCars = cars;
        for (int i = 0; i < n; i++) {
            int[] passing = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            cars += passing[0];
            cars -= passing[1];
            if (cars < 0) {
                maxCars = 0;
                break;
            }
            maxCars = Math.max(maxCars, cars);
        }

        System.out.println(maxCars);
    }
}
