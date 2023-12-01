package programmers;

// 원소들의 곱과 합
public class Prob181929 {
    public int solution(int[] num_list) {
        int[] numbers = num_list;
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        int product = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            product *= numbers[i];
        }
        return product < sum * sum ? 1 : 0;
    }
}
