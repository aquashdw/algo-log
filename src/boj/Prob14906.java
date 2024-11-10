package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.acmicpc.net/problem/14906
public class Prob14906 {
    private static final Pattern slumpSlumpPattern = Pattern.compile("([DE])F+.*G");
    private static final Pattern slumpFullPattern = Pattern.compile("([DE])F+G");
    private static final Pattern slimpSlimpPattern = Pattern.compile("AB.+C");
    private static final Pattern slimpSlumpPattern = Pattern.compile("A.+C");
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        answer.append("SLURPYS OUTPUT\n");
        reader.lines().limit(tests).forEach(line -> {
            // 스림프는 C로 끝나고, 스럼프에는 스림프가 들어오지 않는다. 즉, 마지막 C가 스림프의 끝이어야 한다.
            int slimpBound = line.lastIndexOf('C');
            // C가 없으면?
            if (slimpBound == -1) {
                // 두글자 스림프 "AH"이거나
                if (line.startsWith("AH")) {
                    slimpBound = 1;
                }
                // 스림프가 아니어서 스러피가 아니거나
                else {
                    answer.append("NO\n");
                    return;
                }
            }
            // 스럼프는 최소 길이가 3이다. 남는 공간이 그보다 작다면 스러피가 될 수 없다.
            if (line.length() - slimpBound - 1 < 3) {
                answer.append("NO\n");
                return;
            }
            String slimpCand = line.substring(0, slimpBound + 1);
            String slumpCand = line.substring(slimpBound + 1);
            if (isSlimp(slimpCand) && isSlump(slumpCand)) {
                answer.append("YES\n");
            } else answer.append("NO\n");
        });
        answer.append("END OF OUTPUT\n");
        System.out.print(answer);
    }

    private static boolean isSlimp(String source) {
        if (source.length() == 2) return source.equals("AH");
        Matcher slimpSlimpMatcher = slimpSlimpPattern.matcher(source);
        if (slimpSlimpMatcher.matches()) {
            return isSlimp(source.substring(2, source.length() - 1));
        }
        Matcher slimpSlumpMatcher = slimpSlumpPattern.matcher(source);
        if (slimpSlumpMatcher.matches()) {
            return isSlump(source.substring(1, source.length() - 1));
        }
        return false;
    }

    private static boolean isSlump(String source) {
        if (source.length() == 3) {
            return source.equals("DFG") || source.equals("EFG");
        }
        Matcher slumpFullMatcher = slumpFullPattern.matcher(source);
        if (slumpFullMatcher.matches()) {
            return true;
        }
        Matcher slumpSlumpMatcher = slumpSlumpPattern.matcher(source);
        if (slumpSlumpMatcher.matches()) {
            int start = 2;
            while (source.charAt(start) == 'F') start++;
            return isSlump(source.substring(start));
        }
        return false;
    }
}
/*
2
ADFGCDFFFFFG
ABAEFGCCDFEFFFFFG
 */