package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/19599
public class Prob19599 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = IntStream.range(0, n).toArray();

        int bin = 0;
        int same = 0;
        int ten = 0;
        for (int i = 0; i < n; i++) {
            int binCount = 0;
            int front = 0;
            int back = n - 1;
            while (front <= back) {
                int mid = (front + back) / 2;
                if (arr[mid] == i) {
                    break;
                }
                binCount++;
                if (i < arr[mid]) {
                    back = mid - 1;
                }
                else {
                    front = mid + 1;
                }
            }

            int tenCount = 0;
            front = 0;
            back = n - 1;
            while (front <= back) {
                int leftBorder = front + (back - front) / 3;
                int rightBorder = back - (back - front) / 3;
                if (arr[leftBorder] == i) {
                    break;
                }
                else if(arr[rightBorder] == i) {
                    tenCount++;
                    break;
                }
                tenCount += 2;
                if (i < arr[leftBorder]) {
                    back = leftBorder - 1;
                }
                else if (i < arr[rightBorder]) {
                    front = leftBorder + 1;
                    back = rightBorder - 1;
                }
                else {
                    front = rightBorder + 1;
                }
            }
            if (binCount == tenCount) {
                same++;
            }
            else if (binCount > tenCount) {
                bin++;
            }
            else {
                ten++;
            }
        }
        System.out.printf("%d%n%d%n%d%n", ten, same, bin);
    }
}
