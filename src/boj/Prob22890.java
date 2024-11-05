package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/22890
public class Prob22890 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 1; test <= tests; test++) {
            int n = Integer.parseInt(reader.readLine());
            String[] numStrs = reader.readLine().split(" ");
            BigInteger[] nums = new BigInteger[n];
            int[] digits = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = new BigInteger(numStrs[i]);
                digits[i] = numStrs[i].length();
            }
            int ops = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i].compareTo(nums[i + 1]) < 0) continue;
                // can't change any numbers,
                // so if count of digits are the same while descend,
                // must add 0 at the right
                if (digits[i] == digits[i + 1]) {
                    digits[i + 1]++;
                    nums[i + 1] = nums[i + 1].multiply(BigInteger.valueOf(10));
                    numStrs[i + 1] = String.valueOf(nums[i + 1]);
                    ops++;
                    continue;
                }

                // i starts with digits of i + 1
                if (numStrs[i].startsWith(numStrs[i + 1])) {
                    // check if i ends with only nines
                    // if nines, 0s must be added until i + 1 has more digits than i to be bigger than i
                    if (numStrs[i].substring(digits[i + 1]).chars().allMatch(c -> c == '9')) {
                        int addZeros = digits[i] - digits[i + 1] + 1;
                        for (int j = 0; j < addZeros; j++) {
                            digits[i + 1]++;
                            nums[i + 1] = nums[i + 1].multiply(BigInteger.valueOf(10));
                            ops++;
                        }
                        numStrs[i + 1] = String.valueOf(nums[i + 1]);
                    }
                    // else just add 1 to the remaining and append to i + 1
                    else {
                        int addZeros = digits[i] - digits[i + 1];
                        for (int j = 0; j < addZeros; j++) {
                            digits[i + 1]++;
                            nums[i + 1] = nums[i + 1].multiply(BigInteger.valueOf(10));
                            ops++;
                        }
                        nums[i + 1] = nums[i + 1].add(new BigInteger(numStrs[i].substring(digits[i] - addZeros)).add(BigInteger.ONE));
//                                Long.parseLong(numStrs[i].substring(digits[i + 1])) + 1;
                        numStrs[i + 1] = String.valueOf(nums[i + 1]);
                    }
                    continue;
                }

                // check if i + 1 gets bigger just by adding zeros
                // by comparing most significant digit
                boolean onlyZeros = true;
                for (int j = 0; j < digits[i]; j++) {
                    if (numStrs[i + 1].charAt(j) > numStrs[i].charAt(j)) break;
                    else if (numStrs[i + 1].charAt(j) < numStrs[i].charAt(j)) {
                        onlyZeros = false;
                        break;
                    }
                }
                int addZeros = digits[i] - digits[i + 1] + (onlyZeros ? 0 : 1);
                for (int j = 0; j < addZeros; j++) {
                    digits[i + 1]++;
                    nums[i + 1] = nums[i + 1].multiply(BigInteger.valueOf(10));
                    ops++;
                }
                numStrs[i + 1] = String.valueOf(nums[i + 1]);

            }
            answer.append(String.format("Case #%d: %d%n", test, ops));
        }
        System.out.print(answer);
    }
}

/*
1
90
900000000 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1 9 8 7 6 5 4 3 2 1
 */