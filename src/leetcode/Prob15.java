package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
public class Prob15 {
    public static void main(String[] args) {
        System.out.println(new Prob15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] numbers) {
        numbers = Arrays.stream(numbers).sorted().toArray();
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;
            int target = -numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int now = numbers[left] + numbers[right];
                if (now == target) {
                    answers.add(List.of(numbers[i], numbers[left], numbers[right]));
                    while (left < right && numbers[left] == numbers[left + 1]) left++;
                    while (left < right && numbers[right] == numbers[right - 1]) right--;
                    left++;
                    right--;
                }
                if (now < target) left++;
                if (now > target) right--;
            }
        }
        return answers;
    }
}
