package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10436
public class Prob10436 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < tests + 1; i++) {
            answer.append(i).append(' ');
            String fn = reader.readLine().split(" ")[1];
            long[] pq = Arrays.stream(fn.split("/"))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long p = pq[0];
            long q = pq[1];

            if (p == 1 && q == 1) {
                answer.append("1/2\n");
                continue;
            }
            if (p < q) {
                answer.append(String.format("%d/%d", q, q - p)).append('\n');
                continue;
            }
            if (q == 1) {
                answer.append(String.format("%d/%d", 1, p + 1)).append('\n');
                continue;
            }

            long traverse = p / q;
            p = p % q;
            q -= p;
            p += q;
            q += traverse * p;
            answer.append(String.format("%d/%d", p, q)).append('\n');
        }
        System.out.println(answer.toString().trim());
    }
}
