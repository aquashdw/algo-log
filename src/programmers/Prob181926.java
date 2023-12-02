package programmers;

// 기초
// https://school.programmers.co.kr/learn/courses/30/lessons/181926
class Prob181926 {
    public int solution(int n, String control) {
        int answer = n;
        for(int i = 0; i < control.length(); i++) {
            switch(control.charAt(i)) {
                case 'w' -> answer++;
                case 's' -> answer--;
                case 'd' -> answer += 10;
                case 'a' -> answer -= 10;
            }
        }
        return answer;
    }
}