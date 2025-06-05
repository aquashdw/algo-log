package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2875
public class Prob2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int pairs = info[0] / 2;
        int maxTeams = Math.min(pairs, info[1]);
        int left = 0;
        if (pairs < info[1]) {
            left = info[1] - maxTeams;
        } else if (pairs > info[1]) {
            left = 2 * (pairs - maxTeams);
        }

        if (left >= info[2]) {
            System.out.println(maxTeams);
            return;
        }
        int leftovers = info[2] - left;
        if (leftovers >= maxTeams * 3) {
            System.out.println(0);
            return;
        }
        maxTeams -= leftovers / 3;
        maxTeams -= leftovers % 3 == 0 ? 0 : 1;
        System.out.println(maxTeams);
    }
}
