package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

// https://www.acmicpc.net/problem/28249
public class Prob28249 {
    private static final Map<String, Integer> shu = Map.of(
            "Poblano", 1500,
            "Mirasol", 6000,
            "Serrano", 15500,
            "Cayenne", 40000,
            "Thai", 75000,
            "Habanero", 125000
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(n).mapToInt(shu::get).sum());
    }
}
