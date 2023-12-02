package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181906
public class Prob181906 {
    public int solution(String myString, String isPrefix) {
        if (isPrefix.length() > myString.length())
            return 0;
        for (int i = 0; i < isPrefix.length(); i++) {
            if (myString.charAt(i) != isPrefix.charAt(i))
                return 0;
        }
        return 1;

        // startsWith
        // return myString.startsWith(isPrefix) ? 1 : 0;
    }
}
