package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/26874
public class Prob26874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] finish = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int count = 0;
        List<Integer> sequence = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int target = finish[i];
            int position = 0;
            for (int j = i; j < n; j++) {
                if (target == arr[j] + 1 || target == arr[j] - 1) {
                    System.out.println(-1);
                    return;
                }
                if (arr[j] == target) {
                    position = j;
                    break;
                }
            }

            if (count + position - i > 20000) {
                System.out.println(-1);
                return;
            }

            for (int j = position; j > i; j--) {
                count++;
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                sequence.add(j);

            }
        }
        System.out.printf("%d%n%s%n", count, sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
