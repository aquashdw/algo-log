package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32249
public class Prob32249 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char[][] alice = new char[nm[0]][];
        for (int i = 0; i < nm[0]; i++) {
            alice[i] = reader.readLine().toCharArray();
        }

        char[][] bob = new char[nm[0]][];
        for (int i = 0; i < nm[0]; i++) {
            bob[i] = reader.readLine().toCharArray();
        }

        int q = Integer.parseInt(reader.readLine());
        int[][] exchanges = new int[q][];
        for (int i = 0; i < q; i++) {
            exchanges[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(ch -> Integer.parseInt(ch) - 1).toArray();
        }

        int aliceLastBobs = 0;
        int bobLastAlice = 0;

        for (int i = 0; i < nm[1]; i++) {
            aliceLastBobs += alice[nm[0] - 1][i] == 'A' ? 0 : 1;
            bobLastAlice += bob[nm[0] - 1][i] == 'A' ? 1 : 0;
        }

        StringBuilder answer = new StringBuilder();
        if (aliceLastBobs > 0) answer.append("Alice\n");
        else if (bobLastAlice == 0) answer.append("Alice\n");
        else answer.append("Bob\n");

        for (int i = 0; i < q; i++) {
            int[] exchange = exchanges[i];
            char aliceOrigin = alice[exchange[0]][exchange[1]];
            alice[exchange[0]][exchange[1]] = bob[exchange[2]][exchange[3]];
            bob[exchange[2]][exchange[3]] = aliceOrigin;
            boolean changed = aliceOrigin != alice[exchange[0]][exchange[1]];
            if (exchange[0] == nm[0] - 1 && changed) {
                if (alice[exchange[0]][exchange[1]] == 'A') {
                    aliceLastBobs--;
                } else aliceLastBobs++;
            }
            if (exchange[2] == nm[0] - 1 && changed) {
                if (bob[exchange[2]][exchange[3]] == 'B') {
                    bobLastAlice--;
                } else bobLastAlice++;
            }

            if (aliceLastBobs > 0) answer.append("Alice\n");
            else if (bobLastAlice == 0) answer.append("Alice\n");
            else answer.append("Bob\n");
        }
        System.out.print(answer);
    }
}
