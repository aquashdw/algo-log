package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25238
public class Prob25238 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (info[0] < 100) {
            System.out.println(1);
            return;
        }

        double defence = info[0];
        double reduce = (double) (info[0] * info[1]) / 100;
        defence -= reduce;
        System.out.println(defence < 100 ? 1 : 0);
    }

}
