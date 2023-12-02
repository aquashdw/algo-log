package programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181894
public class Prob181894 {
    public int[] solution(int[] arr) {
        int first = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return new int[]{-1};
        }

        int last = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == 2) {
                last = i;
                break;
            }
        }

//        int[] answer = new int[last - first + 1];
//        for (int i = first; i <= last; i++) {
//            answer[i] = arr[first + i];
//        }
        return Arrays.copyOfRange(arr, first, last + 1);
    }

    public static void main(String[] args) {
        new Prob181894().solution(new int[]{1, 2, 1, 4, 5, 2, 9});
    }
}
