package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BFPatternMatching {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        String pattern = reader.readLine();

        int tarIdx = 0;
        int patIdx = 0;

        List<Integer> foundAt = new ArrayList<>();
        while (tarIdx < target.length() && patIdx < pattern.length()) {
            if (target.charAt(tarIdx) != pattern.charAt(patIdx)) {
                // 시작점 원위치, 맞았던 만큼 돌아간다.
                tarIdx -= patIdx;
                // 다음에 패턴의 첫 위치를 다시 찾기 위해 -1로 초기화
                patIdx = -1;
            }
            // 다음 인덱스 검사
            tarIdx += 1;
            patIdx += 1;
            if (patIdx == pattern.length()) {
                foundAt.add(tarIdx - patIdx);
                tarIdx = tarIdx - patIdx + 1;
                patIdx = 0;
            }
        }

        if (foundAt.isEmpty()) {
            System.out.println("404 NOT FOUND");
        } else {
//            foundAt.forEach(startIdx -> System.out.println(
//                    String.format(
//                            "from %d: %s",
//                            startIdx,
//                            target.substring(
//                                    startIdx, startIdx + pattern.length()
//                            ))));
            foundAt.forEach(System.out::println);
        }

    }

    // qwertyuiuiuytrertyuiopopoiuytrqwertyuytrertywqwertyuiuytrewqwertyuiiuiuiytrewert
    // qwert
    // 0, 30, 45, 59
    public static void main(String[] args) throws IOException {
        new BFPatternMatching().solution();
    }
}
