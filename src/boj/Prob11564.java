package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11564
public class Prob11564 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] params = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        long jump = params[0];
        long left = params[1];
        long right = params[2];

        long start = 0;
        if (left < start) {
            start = (left / jump) * jump;
        }
        else if (left > start){
            start = (left / jump) * jump + (left % jump == 0 ? 0 : jump);
        }
        long diff = right - start;
        if (diff < 0) {
            System.out.println(0);
        }
        else {
            System.out.println(diff / jump + 1);
        }
    }
}

/*
1 2 12
3 2 12
1 -6 6
2 -6 6
3 -4 4
3 -10 -2
3 1 1
 */