package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/31668
public class Prob31668 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = reader.lines().limit(3)
                .mapToInt(Integer::parseInt).toArray();

        int pmts = info[1] / info[0];
        System.out.println(pmts * info[2]);
    }
}
