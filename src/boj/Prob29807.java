package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/29807
public class Prob29807 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] scores = new int[5];
        int idx = 0;
        for (int score : Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()) {
            scores[idx] = score;
            idx++;
        }
        int studentNum = 0;
        studentNum += Math.abs(scores[0] - scores[2]) * (scores[0] > scores[2] ? 508 : 108);
        studentNum += Math.abs(scores[1] - scores[3]) * (scores[1] > scores[3] ? 212 : 305);
        studentNum += scores[4] * 707;
        studentNum *= 4763;
        System.out.println(studentNum);
    }

}
