package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181908
public class Prob181908 {
    public int solution(String myString, String isSuffix) {
        if (isSuffix.length() > myString.length())
            return 0;
        for (int i = 0; i < isSuffix.length(); i++) {
            if (myString.charAt(myString.length() - i - 1)
                != isSuffix.charAt(isSuffix.length() - i - 1))
                return 0;
        }
        return 1;

        // endsWith
        // return myString.endsWith(isSuffix) ? 1 : 0;
    }
}
