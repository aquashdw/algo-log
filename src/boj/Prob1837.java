package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/1837
public class Prob1837 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = reader.readLine().split(" ");
        BigInteger a = new BigInteger(nums[0]);
        BigInteger k = new BigInteger(nums[1]);
        BigInteger b = null;
        for (BigInteger i = BigInteger.TWO; i.compareTo(k) < 0; i = i.add(BigInteger.ONE)) {
            if (a.mod(i).equals(BigInteger.ZERO)) {
                a = a.divide(i);
                b = i;
                break;
            }
        }

        if (b == null) {
            System.out.println("GOOD");
        }
        else if (a.compareTo(b) > 0) {
            System.out.println(String.format("BAD %s", b));
        }
        else System.out.println(String.format("BAD %s", a));

    }
}
