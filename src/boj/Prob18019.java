package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/18019
public class Prob18019 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            long[] lengths = Arrays.stream(line.split(" "))
                    .mapToLong(Long::parseLong).toArray();

            long[] aRect = {lengths[0], lengths[1]};
            long[] bRect = {lengths[2], lengths[3]};
            long[] cRect = {lengths[4], lengths[5]};
            long[][] rects = {aRect, bRect, cRect};

            long minArea = Long.MAX_VALUE;
            // case abc
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        long width = aRect[i];
                        long height = aRect[1 - i];
                        width += bRect[j];
                        height = Math.max(height, bRect[1 - j]);
                        width += cRect[k];
                        height = Math.max(height, cRect[1 - k]);
                        minArea = Math.min(minArea, width * height);
                    }
                }
            }

            boolean[] selected = new boolean[3];
            // case ab-c
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    long[] leftRect = rects[i];
                    long[] rightRect = rects[j];
                    selected[i] = true;
                    selected[j] = true;
                    long[] downRect = rects[IntStream.range(0, 3).filter(idx -> !selected[idx]).sum()];
                    selected[i] = false;
                    selected[j] = false;
                    minArea = Math.min(minArea, area(leftRect, rightRect, downRect));
                }
            }
            answer.append(minArea).append('\n');
        });
        System.out.print(answer);
    }

    private static long area(long[] left, long[] right, long[] down) {
        long minArea = Long.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long width = left[i];
                width += right[j];
                long height = Math.max(left[1 - i], right[1 - j]);

                long heightDiff = Math.abs(left[1 - i] - right[1 - j]);
                long widthDiff;
                if (left[1 - i] == right[1 - j]) {
                    widthDiff = width;
                }
                else if (left[1 - i] < right[1 - j]) {
                    widthDiff = left[i];
                }
                else {
                    widthDiff = right[j];
                }

                for (int k = 0; k < 2; k++) {
                    long downWidth = down[k];
                    long downHeight = down[1 - k];
                    if (downHeight <= heightDiff && downWidth <= widthDiff) {
                        minArea = Math.min(minArea, width * height);
                    }
                    else {
                        long addWidth = downWidth - widthDiff;
                        long addHeight = downHeight - heightDiff;
                        minArea = Math.min(minArea, (width + Math.max(addWidth, 0)) * (height + Math.max(addHeight, 0)));
                    }

                    minArea = Math.min(minArea, Math.max(width, downWidth) * (height + downHeight));
                }
            }
        }
        return minArea;
    }
}
/*

1
2 4 5 1 2 3

2
40158211 2 40627 608 4742094 648240
63 58226168 56249 3872084 69479547 6

1
1 1 1 1 1 1

1
1 1 1 2 1 2

 */