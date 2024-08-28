package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11605
public class Prob11605 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opCount = Integer.parseInt(reader.readLine());
        String[][] ops = new String[opCount][];
        for (int i = 0; i < opCount; i++) {
            ops[i] = reader.readLine().split(" ");
        }

        int count = 0;
        for (int i = 1; i < 101; i++) {
            int left = i;
            for (int j = 0; j < opCount; j++) {
                String[] split = ops[j];
                String command = split[0];
                int right = Integer.parseInt(split[1]);

                if (command.equals("ADD")) left += right;
                else if (command.equals("MULTIPLY")) left *= right;
                else if (command.equals("SUBTRACT")) {
                    if (right > left) {
                        count++;
                        break;
                    }
                    left -= right;
                }
                else if (command.equals("DIVIDE")) {
                    if (left % right != 0) {
                        count++;
                        break;
                    }
                    left /= right;
                }
            }
        }
        System.out.println(count);
    }
}
