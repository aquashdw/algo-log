package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/147355
public class Prob147355 {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String sub = t.substring(i, i + p.length());
            if (!(Long.parseLong(sub) > pValue))
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Prob147355().solution("10203", "15"));
    }
}
