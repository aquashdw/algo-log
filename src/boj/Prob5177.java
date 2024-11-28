package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.acmicpc.net/problem/5177
public class Prob5177 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        Pattern pattern = Pattern.compile("([A-Za-z])+|([0-9])+|( *[.,;:] *)+|( *[({\\[] *)|( *[)}\\]] *)| +");
        Set<Character> specials = Set.of(' ', '.', ',', ';', ':', '(', '{', '[', ')', '}', ']');
        Set<Character> openPars = Set.of('(', '{', '[');
        Set<Character> closePars = Set.of(')', '}', ']');

        for (int i = 0; i < tests; i++) {
            answer.append(String.format("Data Set %d: ", i + 1));
            String aStr = reader.readLine();
            String bStr = reader.readLine();
            int aStart = 0;
            int aEnd = aStr.length();
            while (aStr.charAt(aStart) == ' ') aStart++;
            while (aStr.charAt(aEnd - 1) == ' ') aEnd--;
            aStr = aStr.substring(aStart, aEnd);

            int bStart = 0;
            int bEnd = bStr.length();
            while (bStr.charAt(bStart) == ' ') bStart++;
            while (bStr.charAt(bEnd - 1) == ' ') bEnd--;
            bStr = bStr.substring(bStart, bEnd);

            Matcher aMatcher = pattern.matcher(aStr);
            Matcher bMatcher = pattern.matcher(bStr);

            boolean success = true;
            while (aMatcher.find()) {
                if (!bMatcher.find()) {
                    success = false;
                    break;
                }
                String aMatch = aMatcher.group();
                String bMatch = bMatcher.group();
                // a는 공백
                if (Pattern.matches(" +", aMatch)) {
                    // b는 공백 아님
                    if (!Pattern.matches(" +", bMatch)) {
                        success = false;
                        break;
                    }
                }
                // a의 첫 글자가 공백을 포함한 특수문자 중 하나
                else if (specials.contains(aMatch.charAt(0))) {
                    // b의 첫글자는 특수문자 중 하나가 아니다
                    if (!specials.contains(bMatch.charAt(0))) {
                        success = false;
                        break;
                    }
                    // a의 공백이 아닌 특수문자를 찾는다
                    char aActual = (char) aMatch.chars().filter(c -> c != ' ').sum();
                    // b의 공백이 아닌 특수문자를 찾는다.
                    char bActual = (char) bMatch.chars().filter(c -> c != ' ').sum();
                    // a가 ',', ';' 중 하나면 b도 ',', ';' 중 하나여야 한다.
                    if ((aActual == ';' || aActual == ',')) {
                        if (bActual != ';' && bActual != ',') {
                            success = false;
                            break;
                        }
                    }
                    // a가 여는 괄호면 b도 여는 괄호여야 한다.
                    else if (openPars.contains(aActual) ) {
                        if (!openPars.contains(bActual)) {
                            success = false;
                            break;
                        }
                    }
                    // a가 닫는 괄호면 b도 닫는 괄호여야 한다.
                    else if (closePars.contains(aActual)) {
                        if (!closePars.contains(bActual)) {
                            success = false;
                            break;
                        }
                    }
                    // 나머지는 둘이 같아야 한다.
                    else if (aActual != bActual) {
                        success = false;
                        break;
                    }
                }
                // a가 영글자로 이뤄져 있다.
                else if (Character.isAlphabetic(aMatch.charAt(0))) {
                    // b는 영글자가 아니고, 둘의 길이가 다르다.
                    if (!Character.isAlphabetic(bMatch.charAt(0)) || aMatch.length() != bMatch.length()) {
                        success = false;
                        break;
                    }
                    boolean fail = false;
                    // 각 글자를 대소 무시 비교
                    for (int k = 0; k < aMatch.length(); k++) {
                        if (Character.toLowerCase(aMatch.charAt(k)) != Character.toLowerCase(bMatch.charAt(k))) {
                            fail = true;
                            break;
                        }
                    }
                    if (fail) {
                        success = false;
                        break;
                    }
                }
                // a는 숫자다.
                else if (Character.isDigit(aMatch.charAt(0))) {
                    // b는 숫자가 아니거나, 길이가 다르다.
                    if (!Character.isDigit(bMatch.charAt(0)) || aMatch.length() != bMatch.length()) {
                        success = false;
                        break;
                    }
                    boolean fail = false;
                    // 각 숫자 비교
                    for (int k = 0; k < aMatch.length(); k++) {
                        if (aMatch.charAt(k) != bMatch.charAt(k)) {
                            fail = true;
                            break;
                        }
                    }
                    if (fail) {
                        success = false;
                        break;
                    }
                }
            }
            if (success) success = !bMatcher.find();
            answer.append(success ? "equal\n\n" : "not equal\n\n");
        }
        System.out.print(answer);
    }
}
