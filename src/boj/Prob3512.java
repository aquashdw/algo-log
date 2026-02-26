package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3512
public class Prob3512 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rooms = info[0];
        double pricePerM = info[1];
        int total = 0;
        int bedrooms = 0;
        int balconies = 0;
        for (int i = 0; i < rooms; i++) {
            String[] tokens = reader.readLine().split(" ");
            int area = Integer.parseInt(tokens[0]);
            total += area;
            if (tokens[1].equals("bedroom")) {
                bedrooms += area;
            } else if (tokens[1].equals("balcony")) {
                balconies += area;
            }
        }

        double totalPrice = total * pricePerM;
        totalPrice -= pricePerM * ((double) balconies / 2);
        System.out.printf("%d%n%d%n%f%n", total, bedrooms, totalPrice);
    }
}
