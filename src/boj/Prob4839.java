package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/4839
public class Prob4839 {
    private static final List<Integer> primes = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder answer = new StringBuilder();
        List<String> terms = new ArrayList<>(11);
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            terms.clear();
            int origin = n;
            int nextPrime = 0;
            while (n > 0) {
                int prime = primes.get(nextPrime);
                int mod = n % prime;
                if (mod > 0) {
                    StringBuilder termBuilder = new StringBuilder();
                    termBuilder.append(mod);
                    for (int i = 0; i < nextPrime; i++) {
                        termBuilder.append("*").append(primes.get(i));
                    }
                    terms.add(termBuilder.toString());
                }
                n /= prime;
                nextPrime++;
            }
            String right = String.join(" + ", terms);
            answer.append(origin).append(" = ").append(right).append('\n');
        }
        System.out.print(answer);
    }
}
