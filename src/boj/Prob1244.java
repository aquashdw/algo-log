package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1244 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 첫줄 입력 (스위치 갯수)
        int N = Integer.parseInt(reader.readLine());

        // 스위치 상태 저장
        boolean[] switchState = new boolean[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++){
            String token = tokenizer.nextToken();
            switchState[i] = token.equals("1");
        }

        // 스위치 누를 학생 수
        int students = Integer.parseInt(reader.readLine());

        // 스위치 누를 학생이 남아있을 때
        while (students > 0) {
            tokenizer = new StringTokenizer(reader.readLine());

            // 성별과 숫자
            int gender = Integer.parseInt(tokenizer.nextToken());
            int number = Integer.parseInt(tokenizer.nextToken());

            // 남학생이면 숫자의 배수 스위치를 다 누른다.
            if (gender == 1) {
                int nextSwitch = number - 1;  // n개의 스위치, 배열은 n-1까지, 첫 스위치는 숫자 - 1
                while (nextSwitch < N) {
                    switchState[nextSwitch] = !switchState[nextSwitch];
                    nextSwitch += number;
                }
            }
            // 여학생이면 숫자부터 가장 큰 대칭 구간의 스위치를 다 누른다.
            else if (gender == 2){
                int position = number - 1;
                switchState[position] = !switchState[position];
                int offset = 1;
                while (position + offset < N && position - offset > -1) {
                    if (switchState[position + offset] == switchState[position - offset]) {
                        switchState[position + offset] = !switchState[position + offset];
                        switchState[position - offset] = !switchState[position - offset];
                    }
                    else break;
                    offset++;
                }
            }
            students--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 한줄의 출력은 20개만
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            stringBuilder
                    .append(switchState[i] ? 1 : 0)
                    .append(' ');
            cnt++;
            // 20개가 채워지면
            if(cnt == 20) {
                cnt = 0;
                // 일단 출력을 해보자
                System.out.println(stringBuilder);
                stringBuilder = new StringBuilder();
            }
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws IOException {
        new Prob1244().solution();
    }
}