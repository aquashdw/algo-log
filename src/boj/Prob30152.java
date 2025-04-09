package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30152
public class Prob30152 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        reader.lines().limit(tests).forEach(line -> {
            int[] nm = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (nm[0] == 1) {
                System.out.println(0);
                return;
            }
            if (nm[0] == 2) {
                System.out.println(nm[1]);
                return;
            }
            if (nm[1] == 1) {
                System.out.println(nm[0] - 1);
                return;
            }
            int oneSkill = nm[0] - 1;
            System.out.println(oneSkill + 2 * (nm[1] - 1));
        });
    }
}
