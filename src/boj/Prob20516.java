package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/20516
public class Prob20516 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int oneThird = n / 3 - 1;
        System.out.println(switch (n % 3) {
            case 0 -> String.format("%d %d %d%n", oneThird, oneThird + 1, oneThird + 2);
            case 1 -> String.format("%d %d %d%n", oneThird, oneThird + 1, oneThird + 3);
            case 2 -> String.format("%d %d %d%n", oneThird, oneThird + 2, oneThird + 3);
            default -> throw new IllegalArgumentException("Invalid input");
        });
    }
}
/*

if n % 3 == 0
   k = n / 3 - 1
   k, k+1, k+2

if n % 3 == 1
   k = (n - 1) / 3 - 1
   k, k+1, k+3

if n % 3 == 2
   k = (n - 2) / 3 - 1
   k, k+2, k+3


 */
