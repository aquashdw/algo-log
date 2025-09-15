package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12994
public class Prob12994 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (xy[0] == 0 && xy[1] == 0) {
            System.out.println(1);
            return;
        }

        int x = xy[0];
        int y = xy[1];

        int step = 1;
        while (x != 0 || y != 0) {
            boolean flag = false;
            if (x != 0 && (x + step) % (step * 3) == 0) {
                x += step;
                flag = true;
            } else if (x != 0 && (x - step) % (step * 3) == 0) {
                x -= step;
                flag = true;
            } else if (y != 0 && (y + step) % (step * 3) == 0) {
                y += step;
                flag = true;
            } else if (y != 0 && (y - step) % (step * 3) == 0) {
                y -= step;
                flag = true;
            }


            if (flag) {
                step *= 3;
                continue;
            }
            break;
        }

        System.out.println((x == 0 && y == 0) ? 1 : 0);
    }
}
