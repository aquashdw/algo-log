package programmers;


// https://school.programmers.co.kr/learn/courses/30/lessons/181942
public class Prob181942 {
    public String solution(String str1, String str2) {
        StringBuilder lineBuilder = new StringBuilder();
        for(int i = 0; i < str1.length(); i++) {
            lineBuilder.append(str1.charAt(i));
            lineBuilder.append(str2.charAt(i));
        }
        return lineBuilder.toString();
    }
}
