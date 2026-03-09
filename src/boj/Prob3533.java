package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3533
public class Prob3533 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ones = Arrays.stream(reader.readLine().split(" "))
                .filter(token -> token.equals("1")).toArray().length;
        int zeros = 10 - ones;
        if (zeros == 0 || zeros == 1) {
            System.out.println(1);
            return;
        }
        if (zeros == 10) {
            System.out.println(0);
            return;
        }
        // 10C2 == 10 * 9 / 2 == 45
        // 10C3 == 10 * 9 * 8 / 3 * 2 * 1 == 120
        int count = 165 - zeros * (zeros - 1) / 2;
        if (zeros > 2) {
            count -= zeros * (zeros - 1) * (zeros - 2) / 6;
        }
        System.out.println(count % 2);

    }
}

/*
1 1 1 0 0
1 1 -> 3C2
1 1 -> 3C2
1 0 -> 3C1 2C1
1 0 -> 3C1 2C1
1 1 -> 3C2
1 0 -> 3C1 2C1
1 0 -> 3C1 2C1
1 0 -> 3C1 2C1
1 0 -> 3C1 2C1
0 0 -> 2C2

1 1 1 -> 3C3
1 1 0 -> 3C2 2C1
1 1 0 -> 3C2 2C1
1 1 0 -> 3C2 2C1
1 1 0 -> 3C2 2C1
1 1 0 -> 3C2 2C1
1 1 0 -> 3C2 2C1
1 0 0 -> 3C1 2C2
1 0 0 -> 3C1 2C2
1 0 0 -> 3C1 2C2
 */
