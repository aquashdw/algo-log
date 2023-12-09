package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/2839
public class Prob2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int count = n / 5;
        int r = n % 5;
        switch (r) {
            case 0:
                System.out.println(count);
                break;
            case 1:
                if (count != 0)
                    System.out.println(count + 1);
                else
                    System.out.println(-1);
                break;
            case 2:
                if (n >= 12)
                    System.out.println(count + 2);
                else
                    System.out.println(-1);
                break;
            case 3:
                System.out.println(count + 1);
                break;
            case 4:
                if (count != 0)
                    System.out.println(count + 2);
                else
                    System.out.println(-1);
                break;
        }

    }
}
