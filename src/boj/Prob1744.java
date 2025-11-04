package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1744
public class Prob1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = reader.lines().limit(n).mapToInt(Integer::parseInt).sorted().toArray();
        int posStart = 0;
        while (posStart < n && arr[posStart] <= 0) posStart++;
        int sum = 0;
        for (int i = 0; i < posStart / 2; i++) {
            sum += arr[2 * i] * arr[2 * i + 1];
        }
        if (posStart % 2 != 0) sum += arr[posStart - 1];

        int i = n - 1;
        int carry = -1;
        while (i >= posStart) {
            if (arr[i] > 1) {
                if (carry != -1) {
                    sum += arr[i] * carry;
                    carry = -1;
                    i--;
                } else {
                    carry = arr[i];
                    i--;
                }
            } else break;
        }

        if (carry != -1) sum += carry;
        while (i >= posStart && arr[i] == 1) {
            sum += arr[i];
            i--;
        }
        System.out.println(sum);
    }
}
