package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/34126
public class Prob34126 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] chocos = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int height = 0;
            height += (chocos[2] / 2) * 3;
            chocos[2] %= 2;
            if (chocos[2] > 0) {
                height += 3;
                int space = 3;
                if (chocos[1] > 0) {
                    chocos[1]--;
                    space -= 2;
                }
                while (chocos[0] > 0 && space > 0) {
                    chocos[0]--;
                    space--;
                }
            }
            height += chocos[1];
            height += (chocos[0] + 1) / 2;
            answer.append(height).append('\n');
        }
        System.out.print(answer);
    }

}
/*

AC
AB
AB

B
BC

BB
C

BB
A
AB
AB

 B
AB
AB
AB
 */