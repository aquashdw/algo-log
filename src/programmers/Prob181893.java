package programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181893
public class Prob181893 {
    public int[] solution(int[] arr, int[] query) {
        int upperBound = arr.length;
        int lowerBound = 0;
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                upperBound = lowerBound + query[i] + 1;
            }
            else {
                lowerBound += query[i];
            }
        }

        return Arrays.copyOfRange(arr, lowerBound, upperBound);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prob181893().solution(new int[]{0, 1, 2, 3, 4, 5}, new int[]{4, 1, 2})));
    }
}
