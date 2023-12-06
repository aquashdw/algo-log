package programmers;


// https://school.programmers.co.kr/learn/courses/30/lessons/181898
public class Prob181898 {
    public int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1)
                return i;
        }
        return -1;
    }
}
