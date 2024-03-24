package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/2775
public class Prob2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 0; t < tests; t++) {
            int k = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());

            long top = 1;
            long bot = 1;
            for (long i = 1; i <= n - 1; i++) {
                top *= n + k - i + 1;
                bot *= i;
            }
            System.out.println(top / bot);
        }
    }
}
