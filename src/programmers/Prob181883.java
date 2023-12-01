package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181883
public class Prob181883 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            for (int j = start; j < end + 1; j++) {
                answer[j]++;
            }
        }
        return answer;
    }
}
