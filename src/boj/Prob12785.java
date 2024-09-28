package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12785
public class Prob12785 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] map = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] toast = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long[][] toastWays = new long[toast[0]][toast[1]];
        Arrays.fill(toastWays[0], 1);
        for (int i = 1; i < toast[0]; i++) {
            toastWays[i][0] = 1;
            for (int j = 1; j < toast[1]; j++) {
                toastWays[i][j] = (toastWays[i - 1][j] + toastWays[i][j - 1]) % 1000007;
            }
        }
        if (map[0] == toast[0] || map[1] == toast[1]) {
            System.out.println(toastWays[toast[0] - 1][toast[1] - 1]);
            return;
        }

        long[][] schoolWays = new long[map[0] - toast[0] + 1][map[1] - toast[1] + 1];
        Arrays.fill(schoolWays[0], 1);
        for (int i = 1; i < schoolWays.length; i++) {
            schoolWays[i][0] = 1;
            for (int j = 1; j < schoolWays[0].length; j++) {
                schoolWays[i][j] = (schoolWays[i - 1][j] + schoolWays[i][j - 1]) % 1000007;
            }
        }
        long ways = ((toastWays[toast[0] - 1][toast[1] - 1]) *
                (schoolWays[schoolWays.length - 1][schoolWays[0].length - 1])) % 1000007;
        System.out.println(ways);
    }
}

