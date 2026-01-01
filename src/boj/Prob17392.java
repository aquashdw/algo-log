package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17392
public class Prob17392 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] happy = info[0] > 0 ? Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray() : new int[]{};

        int days = info[1];
        int spaces = happy.length + 1;
        int left = days - Arrays.stream(happy).map(i -> i + 1).sum();
        if (left < 0) {
            System.out.println(0);
            return;
        }
        if (left < spaces) {
            System.out.println(left);
            return;
        }

        int base = left / spaces;
        int over = left % spaces;
        int unhappy = 0;
        for (int i = 0; i < spaces; i++) {
            int lonely = base;
            if (over > 0) {
                over--;
                lonely++;
            }

            while (lonely-- > 0) {
                unhappy += (lonely + 1) * (lonely + 1);
            }
        }
        System.out.println(unhappy);
    }
}
