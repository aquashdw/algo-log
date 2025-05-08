package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4632
public class Prob4632 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String widthIn;
        while (!(widthIn = reader.readLine()).strip().equals("0")) {
            int maxWidth = Integer.parseInt(widthIn);
            int ceilWidth = 0;
            int ceilHeight = 0;
            int rowWidth = 0;
            int rowHeight = 0;
            String line;
            while (!(line = reader.readLine()).strip().equals("-1 -1")) {
                int[] window = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (window[0] + rowWidth > maxWidth) {
                    ceilWidth = Math.max(ceilWidth, rowWidth);
                    rowWidth = window[0];

                    ceilHeight += rowHeight;
                    rowHeight = window[1];
                } else {
                    rowWidth += window[0];
                    rowHeight = Math.max(rowHeight, window[1]);
                }
            }
            ceilWidth = Math.max(ceilWidth, rowWidth);
            ceilHeight += rowHeight;

            answer.append(ceilWidth).append(" x ").append(ceilHeight).append('\n');
        }
        System.out.print(answer);
    }
}
