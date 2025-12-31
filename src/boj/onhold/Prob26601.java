package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/26601
public class Prob26601 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] primes = sieve(n);
        Queue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        // base, exp, value
        Arrays.stream(primes).forEach(prime -> queue.offer(new long[]{prime, prime}));

        long answer = 1;
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) break;
            long[] next = queue.poll();
            answer *= next[1];
            answer %= 2_000_003;
            // 1 -> 3 -> 7 -> 15
            //   2 -> 4 -> 8
            next[1] *= next[1];
            queue.offer(next);
        }

        System.out.println(answer);
    }

    private static long[] sieve(int n) {
        boolean[] isPrime = new boolean[2_000_004];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        int last = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i * i; j > i && j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
            if (count == n) {
                last = i;
                break;
            }
        }
        return IntStream.range(0, Math.min(last + 1, isPrime.length))
                .filter(i -> isPrime[i])
                .mapToLong(Long::valueOf)
                .toArray();
    }
}
/*
83160 2
41580 2
20790 2
10395 3
3465 3
1155 3
385 5
77 7
11

2^3 * 3^3 * 5^1 * 7^1 * 11^1
4 * 4 * 2 * 2 * 2
2^2 * 2^2 * 2 * 2 * 2
2^7

2^1 * 3^1 * 5^1 * 7^1
2 * 2 * 2 * 2
2^4


a b c d e f g
1 1 1 1 1 1 1
2 2 2 2 2 2 2

a b c d e f -
3 1 1 1 1 1
4 2 2 2 2 2

a b c d e
3 3 1 1 1
4 4 2 2 2


a b c d e f g h
1 1 1 1 1 1 1 1
2 2 2 2 2 2 2 2

a b c d e f
7 1 1 1 1 1
8 2 2 2 2 2

뒤쪽 소인수들을 앞쪽 소인수로 바꾸는게 합리적인 경우
앞쪽 소인수를 다음 2^n - 1 갯수 만큼 늘리기 위해 곱하는 값의 크기가
제거하는 두쪽 소인수들의 총 곱 보다 작은 경우

뒤쪽 소인수를 제거하면 앞쪽 소인수는 그 갯수가 +1 했을 때 2^n 꼴이 되어야
최종 약수의 갯수가 2^N이 된다.

 */