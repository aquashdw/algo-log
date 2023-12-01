package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2231 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(reader.readLine());

        for (int i = 0; i < target + 1; i++) {
            int number = i;
            int sum = number;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            if (sum == target) return i;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob2231().solution());
    }
}
