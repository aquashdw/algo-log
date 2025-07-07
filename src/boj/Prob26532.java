package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26532
public class Prob26532 {
    private static final int sqrYardsPerBag = 5 * 4840;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] yards = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int area = yards[0] * yards[1];
        int bags = area / sqrYardsPerBag + (area % sqrYardsPerBag == 0 ? 0 : 1);
        System.out.println(bags);
    }
}
