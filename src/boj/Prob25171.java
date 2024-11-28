package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25171
public class Prob25171 {
    private static long monAttack;
    private static long monHealth;
    private static long myAttack;
    private static long myHealth;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] monster = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        monAttack = monster[0];
        monHealth = monster[1];
        long[] cards = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        long sum = Arrays.stream(cards).sum();
        long count = 0;
        for (int i = 0; i < n; i++) {
            myAttack = 0;
            for (int j = i + 1; j < n + 1; j++) {
                myAttack += cards[j - 1];
                myHealth = sum - myAttack;
                if (!win()) continue;

                int aFront = 0;
                while (aFront >= i && aFront < j) aFront++;
                int aBack = aFront + 1;
                while (aBack >= i && aBack < j) aBack++;
                myHealth = cards[aFront];
                // until front reaches end
                while (aFront < n) {
                    // find first back that wins
                    while (!win() && aBack < n) {
                        myHealth += cards[aBack];
                        aBack++;
                        while (aBack >= i && aBack < j) aBack++;
                    }
                    // if back is end, but cannot win stop looping
                    if (aBack == n && !win()) break;

                    // add remaining indices to count (any higher health is okay)
                    if (aBack <= i) {
                        count += n - aBack - (j - i) + 1;
                    }
                    else if (aBack <= j) {
                        count += n - aBack - (j - aBack) + 1;
                    }
                    else {
                        count += n - aBack + 1;
                    }

                    // decrease health, increment first
                    myHealth -= cards[aFront];
                    aFront++;
                    while (aFront >= i && aFront < j) aFront++;
                }
                // repeat
            }
        }
        
        System.out.println(count == 0 ? "IMPOSSIBLE" : count);
    }

    private static boolean win() {
        if (myAttack == 0 || myHealth == 0) return false;
        return monHealth / myAttack + (monHealth % myAttack == 0 ? 0 : 1) <
                myHealth / monAttack + (myHealth % monAttack == 0 ? 0 : 1);
    }
}
/*
5
5 5
1 2 3 5 7

1 - X
(1,2) - (3,5,7), (5,7) {2turns}
(1,2,3) - (5,7), (7) {1turn}
(1,2,3,5) - (7) {1turn}
(1,2,3,5,7) - X
=> 5

2 - (1,3,5,7) {3turns}
(2,3) - (1,5), (1,5,7), (5,7), (7) {1turn}
(2,3,5) - (1,7), (7) {1turn}
(2,3,5,7) - X
=> 7

3 - (1,2,5,7), (2,5,7), (5,7) {2turns}
(3,5) - (1,2,7), (2,7), (7) {1turn}
(3,5,7) - X
=> 6

5 - (1,2,3), (1,2,3,7), (2,3,7), (3,7), (7) {1turn}
(5,7) - (1,2,3) {1turn}
=> 6

7 - (1,2,3), (1,2,3,5), (2,3,5), (3,5) {1turn}
=> 4
 */
