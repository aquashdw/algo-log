package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181928
public class Prob181928 {
    public int solution(int[] numbers) {
        StringBuilder oddNums = new StringBuilder();
        StringBuilder evenNums = new StringBuilder();
        for (int num : numbers) {
            if (num % 2 == 0) evenNums.append(num);
            else oddNums.append(num);
        }

        return Integer.parseInt(evenNums.toString()) + Integer.parseInt(oddNums.toString());
    }
}
