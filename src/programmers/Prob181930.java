package programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181930
public class Prob181930 {
//    public int solution(int a, int b, int c) {
//        // 어떤 상황에든 a + b + c 점은 얻는다.
//        int answer = a + b + c;
//        if (a == b) {
//            // 일단 2개 일치
//            answer *= a * a + b * b + c * c;
//            // 3개 일치
//            if (b == c) {
//                answer *= a * a * a + b * b * b + c * c * c;
//            }
//        }
//        else if (b == c || a == c) {
//            // a != b 이기 때문에 2개 일치
//            answer *= a * a + b * b + c * c;
//        }
//        return answer;
//    }
    public int solution(int a, int b, int c) {
        int[] numbers = {a, b, c};
        Arrays.sort(numbers);
        if (numbers[0] == numbers[2]) {
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        } else if (numbers[0] == numbers[1] || numbers[1] == numbers[2]) {
            return (a + b + c) * (a * a + b * b + c * c);
        } else {
            return (a + b + c);
        }
    }
}
