package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1002
public class Prob1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            String[] info = reader.readLine().split(" ");
            answerBuilder.append(possiblePoints(
                    Integer.parseInt(info[0]),
                    Integer.parseInt(info[1]),
                    Integer.parseInt(info[2]),
                    Integer.parseInt(info[3]),
                    Integer.parseInt(info[4]),
                    Integer.parseInt(info[5])
            ));
            answerBuilder.append('\n');
        }
        System.out.print(answerBuilder);
    }

    public static int possiblePoints(int x1, int y1, int d1, int x2, int y2, int d2) {
        // 같은 점
        if (x1 == x2 && y1 == y2 && d1 == d2) return -1;
        int xDiff = x1 - x2;
        int yDiff = y1 - y2;
        // 두 터렛 사이의 거리
        int xyRange = xDiff * xDiff + yDiff * yDiff;
        if (xyRange > (d1 + d2) * (d1 + d2)) return 0;
        if (xyRange < (d1 - d2) * (d1 - d2)) return 0;
        if (xyRange == (d1 + d2) * (d1 + d2)) return 1;
        if (xyRange == (d1 - d2) * (d1 - d2)) return 1;
        return 2;
    }
}
