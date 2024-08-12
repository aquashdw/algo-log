package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/24981
public class Prob24981 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> lCows = new PriorityQueue<>(n);
        Queue<Integer> gCows = new PriorityQueue<>(n);
        reader.lines().limit(n).forEach(line -> {
            String[] info = line.split(" ");
            String lg = info[0];
            int idx = Integer.parseInt(info[1]);
            if (lg.equals("L")) lCows.add(idx);
            else if (lg.equals("G")) gCows.add(idx);
        });

        if (lCows.isEmpty() || gCows.isEmpty()) {
            System.out.println(0);
            return;
        }

        int minLiars = gCows.size();
        int liars = gCows.size();

        while (!lCows.isEmpty()) {
            int lCow = lCows.poll();
            while (!gCows.isEmpty() && gCows.peek() <= lCow) {
                liars--;
                gCows.poll();
            }
            minLiars = Math.min(minLiars, liars);
            liars++;
        }

        System.out.println(minLiars);
    }
}
/*
4
L 1
L 3
G 2
G 4
0 -> 2
1 -> 2
2 -> 2
3 -> 2
4 -> 2
 */

/*
6
L 1
L 3
L 4
G 2
G 4
G 6
 */

/*
4
L 5
L 3
G 1
G 3
 */