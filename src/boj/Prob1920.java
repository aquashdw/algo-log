package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1920
public class Prob1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] numbersRaw = reader.readLine().split(" ");
        int[] numbers = Arrays.stream(numbersRaw)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int M = Integer.parseInt(reader.readLine());
        String[] targetsRaw = reader.readLine().split(" ");
        int[] targets = Arrays.stream(targetsRaw)
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder answerBuilder = new StringBuilder();
        for (int target : targets) {
            if (binarySearch(numbers, target))
                answerBuilder.append(1);
            else answerBuilder.append(0);
            answerBuilder.append('\n');
        }
        System.out.print(answerBuilder);
    }

    // 이진 탐색
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // 왼쪽 인덱스가 오른쪽 인덱스보다 커지면 발견 실패
        while (left <= right) {
            // 현재 기준에서 절반 지점을 기준으로,
            int mid = left + (right - left) / 2;

            // 가운데에서 발견
            if (arr[mid] == target) {
                return true;
                // 찾는 숫자보다 작다면 지금보다 오른쪽에서 찾는다.
            } else if (arr[mid] < target) {
                left = mid + 1;
                // 찾는 숫자보다 크다면 지금보다 왼쪽에서 찾는다.
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
