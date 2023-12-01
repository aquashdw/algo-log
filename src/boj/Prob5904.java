package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob5904 {
    public char solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int length = 3;
        int reps = 0;
        while (length < n) {
            reps++;
            length = length * 2 + (reps + 3);
        }
        n--;

        while (true) {
            int midIndex = (length - (reps + 3)) / 2;
            int lastIndex = (length + reps + 3) / 2;
            if (n == midIndex) return 'm';
            else if (midIndex < n && n < lastIndex) {
                return 'o';
            }
            else if (n >= lastIndex) {
                n -= lastIndex;
                length -= lastIndex;
            } else {
                length -= reps + 3;
                length -= midIndex;
            }
            reps--;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob5904().solution());
    }
}
