package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/20529
public class Prob20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            reader.readLine();
            answer.append(triangulate(reader.readLine().split(" "))).append('\n');
        }
        System.out.print(answer);
    }

    public static int triangulate(String[] people) {
        if (people.length > 32)
            return 0;
        int n = people.length;
        int totalDist = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    totalDist = Math.min(
                            totalDist,
                            distance(people[i], people[j]) +
                            distance(people[j], people[k]) +
                            distance(people[k], people[i])
                    );
                }
            }
        }
        return totalDist;
    }
    
    public static int distance(String left, String right) {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += left.charAt(i) != right.charAt(i) ? 1 : 0;
        }
        return total;
    }
}
