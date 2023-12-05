package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/161989
public class Prob161989 {
    public int solution(int n, int m, int[] section) {
        int paints = 1;
        int start = section[0];
        for (int left : section) {
            if (start + m - 1 < left) {
                start = left;
                paints++;
            }
        }

        return paints;

        /*boolean[] painted = new boolean[section.length];
        int paints = 0;
        for (int i = 0; i < section.length; i++) {
            if (painted[i]) continue;
            painted[i] = true;
            for (int j = i + 1; j < section.length; j++) {
                if (section[j] < i + m)
                    painted[j] = true;
                else break;
            }
            paints++;
        }
        return paints;*/
    }

    public static void main(String[] args) {
        System.out.println(new Prob161989().solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(new Prob161989().solution(5, 4, new int[]{1, 3}));
        System.out.println(new Prob161989().solution(4, 1, new int[]{1, 2, 3, 4}));
        System.out.println(new Prob161989().solution(10, 2, new int[]{1, 3, 6, 8, 10}));
        System.out.println(new Prob161989().solution(5, 2, new int[]{1, 4}));
    }
}
