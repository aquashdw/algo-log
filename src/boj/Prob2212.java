package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2212
public class Prob2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sensorCount = Integer.parseInt(reader.readLine());
        int antennaCount = Integer.parseInt(reader.readLine());
        int[] sensors = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int[] distances = new int[sensorCount - 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(distances);

        int sum = 0;
        for (int i = 0; i < sensorCount - antennaCount; i++) {
            sum += distances[i];
        }
        System.out.println(sum);
    }
}
