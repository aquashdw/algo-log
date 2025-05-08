package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/10972
public class Prob10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
        reader.readLine();
        int[] now = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = now.length;
        Queue<Integer> seen = new PriorityQueue<>();
        int down = n - 1;
        int max = 0;
        while (down > 0 && now[down - 1] > now[down]) {
            seen.add(now[down]);
            max = Math.max(max, now[down]);
            down--;
        }
        if (down == 0) {
            System.out.println(-1);
            return;
        }

        seen.add(now[down]);
        max = Math.max(max, now[down]);
        down--;

        Queue<Integer> toInsert = new PriorityQueue<>();
        int next = max;
        while (!seen.isEmpty()) {
            int insert = seen.poll();
            if (insert > now[down]) next = Math.min(insert, next);
            toInsert.add(insert);
        }
        toInsert.add(now[down]);
        now[down] = next;
        while (!toInsert.isEmpty()) {
            int insert = toInsert.poll();
            if (insert == next) continue;
            down++;
            now[down] = insert;
        }

        System.out.println(Arrays.stream(now).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}

/*
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1


2 3 1 4 5
2 3 1 5 4

4 5 3 2 1
5 1 2 3 4


4 3 5 2 1
4 5 1 2 3
 */
