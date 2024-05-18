package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5525
public class Prob5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        int count = 0;
        int start = 0;
        while (start < m - 2) {
            if (s.charAt(start) == 'I') {
                int end = start;
                while (end < m - 2 && s.charAt(end + 1) == 'O' && s.charAt(end + 2) == 'I') {
                    end += 2;
                }
                int space = (end - start) / 2 - (n - 1);
                count += Math.max(space, 0);
                start = end;
            }
            start++;
        }

        System.out.println(count);
    }
}
