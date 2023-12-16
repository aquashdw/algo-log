package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// https://www.acmicpc.net/problem/2143
public class Prob2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int[] aArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(reader.readLine());
        int[] bArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Long, Integer> aSubArrSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long subSum = 0;
            for (int j = i; j < n; j++) {
                subSum += aArr[j];
                aSubArrSumMap.put(subSum, aSubArrSumMap.getOrDefault(subSum, 0) + 1);
            }
        }

        Map<Long, Integer> bSubArrSumMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long subSum = 0;
            for (int j = i; j < m; j++) {
                subSum += bArr[j];
                bSubArrSumMap.put(subSum, bSubArrSumMap.getOrDefault(subSum, 0) + 1);
            }
        }

        long[] aSumArray = aSubArrSumMap.keySet().stream()
                .mapToLong(Long::longValue)
                .sorted()
                .toArray();
        long[] bSumArray = bSubArrSumMap.keySet().stream()
                .mapToLong(Long::longValue)
                .sorted()
                .toArray();

        long count = 0;
        int aSumCount = aSumArray.length;
        int bSumCount = bSumArray.length;
        int left = 0;
        int right = bSumCount - 1;

        while (true) {
            if (right < 0 || left > aSumCount - 1) break;
            long sum = aSumArray[left] + bSumArray[right];
            if (sum == t) {
                count += (long) aSubArrSumMap.get(aSumArray[left]) * bSubArrSumMap.get(bSumArray[right]);
                left++;
                right--;
                continue;
            }
            if (left < aSumCount - 1 && sum < t) {
                left++;
                continue;
            }
            if (right > 0 && sum > t) {
                right--;
                continue;
            }
            break;
        }

        System.out.println(count);
    }
}
