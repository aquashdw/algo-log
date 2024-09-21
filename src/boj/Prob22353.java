package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/22353
public class Prob22353 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        double time = info[0];
        double winProb = info[1] / 100.0;
        double upProb = info[2] / 100.0;

        double loseProb = 1;
        double expected = 0;
        int reps = 1;
        while (true) {
            expected += time * reps * winProb * loseProb;
            loseProb *= 1 - winProb;
            if (winProb == 1) break;
            winProb += winProb * upProb;
            if (winProb > 1) winProb = 1;
            reps++;
        }
        System.out.println(expected);
    }
}

