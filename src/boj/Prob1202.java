package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


// https://www.acmicpc.net/problem/1202
public class Prob1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] jewelsAndBags = reader.readLine().split(" ");
        int n = Integer.parseInt(jewelsAndBags[0]);
        int m = Integer.parseInt(jewelsAndBags[1]);
        // 보석 정보
        int[][] jewels = new int[n][];
        for (int i = 0; i < n; i++) {
            jewels[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // 가벼운 순 정렬
        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));

        int[] wPerBag = new int[m];
        // 가방들 정보
        for (int i = 0; i < m; i++) {
            wPerBag[i] = Integer.parseInt(reader.readLine());
        }
        // 정렬한다.
        Arrays.sort(wPerBag);

        long max = 0;
        int lastJewel = 0;
        PriorityQueue<int[]> canAdd = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        for (int weight : wPerBag) {
            while (lastJewel < n && jewels[lastJewel][0] <= weight) {
                canAdd.offer(jewels[lastJewel]);
                lastJewel++;
            }
            if (!canAdd.isEmpty()) max += canAdd.poll()[1];
        }
        System.out.println(max);
    }
}
