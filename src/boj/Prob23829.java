package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/23829
public class Prob23829 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nq = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        long[] trees = new long[nq[0] + 1];
        Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .reduce(1, (idx, tree) -> {
                    trees[(int) idx] = tree;
                    return idx + 1;
                });
        long[] sums = new long[nq[0] + 1];
        sums[1] = trees[1];
        for (int i = 2; i < nq[0] + 1; i++) {
            sums[i] = sums[i - 1] + trees[i];
        }

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(nq[1]).mapToLong(Long::parseLong)
                .forEach(shot -> {
                    int front = 1;
                    int back = nq[0];
                    int mid = 0;
                    while (front <= back) {
                        mid = (front + back) / 2;
                        if (trees[mid] < shot) {
                            front = mid + 1;
                        }
                        else if (trees[mid] > shot) {
                            back = mid - 1;
                        }
                        else break;
                    }

                    long points = 0;
                    if (trees[mid] <= shot) {
                        points += (mid * shot) - sums[mid];
                        points += sums[nq[0]] - sums[mid] - (nq[0] - mid) * shot;
                    }
                    else {
                        points += (mid - 1) * shot - sums[mid - 1];
                        points += sums[nq[0]] - sums[mid - 1] - (nq[0] - mid + 1) * shot;
                    }

                    answer.append(points).append('\n');
                });
        System.out.print(answer);
    }
}
/*
6 3
1 3 4 7 9 10
4
12
10

5 3
1 3 7 9 10
3
12
10

5 6
5 10 15 20 25
1
7
15
20
22
30

 */