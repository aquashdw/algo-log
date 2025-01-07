package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/31793
public class Prob31793 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(reader.readLine());
        long totalBalls = (long) Math.pow(2, depth) - 1;
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToLong(Long::parseLong).forEach(num -> {
            answer.append(find(num, 1, totalBalls, false)).append('\n');
        });
        System.out.print(answer);
    }

    private static long find(long target, long node, long remains, boolean left) {
        // left && even -> right
        // left && !even -> left
        // !left && even -> left
        // !left && !even -> right
        if (target == remains) return node;
        boolean even = target % 2 == 0;
        long next = (target + (even ? 0 : 1)) / 2;
        remains = (remains - 1) / 2;
        if (left == even) {
            return find(next, node * 2 + 1, remains, false);
        }
        else {
            return find(next, node * 2, remains, true);
        }
    }
}
/*
5
5
1
2
3
4
5

루트를 기준으로 처음에 남은 숫자들(2^N - 1개)을 순서대로 나열시 홀수번째는 오른쪽, 짝수번째는 왼쪽
그 다음
- 오른쪽 위에 루트가 있으면 (2번) 순서대로 나열시 홀수번째는 왼쪽, 짝수번째는 오른쪽
- 왼쪽 위에 루트가 있으면 (3번) 순서대로 나열시 홀수번째는 오른쪽, 짝수번째는 왼쪽
이 된다.

즉 구해야 되는 공이 루트가 될때까지 /2 (홀수의 경우 +1) 을 해가며
- 왼쪽으로 갈경우 * 2
- 오른쪽으로 갈경우 * 2 + 1
을 해준다 (이진트리니까)

이때 루트인 상황은 남은 공의 갯수가 나와 같아질 때 까지
N = 5
2^N - 1 = 31
1  R R R
2  L
3  R L
4  L
5  R R L
6  L
7  R L
8  L
9  R R R
10 L
11 R L
12 L
13 R R L
14
15 R L
16
17 R R R
18
19 R L
20
21 R R L
22
23 R L
24
25 R R -
26
27 R L
28
29 R -
30
31 R
 */


/*
1  - 1 R
3  - 2
5  - 3 R
7  - 4
9  - 5 R
11 - 6
13 - 7 R
15 - 8
17 - 9 R
19 - 10
21 - 11 R
23 - 12
25 - 13 -
27 - 14
29
31

1  1 R
3  2
5  3 R
7  4
9  5 R
11 6
13 7

 */