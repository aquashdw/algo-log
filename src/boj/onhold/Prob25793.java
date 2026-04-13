package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/25793
public class Prob25793 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*
        제일 아래층부터 하나씩 채워나간다고 가정하면
        각 층의 아래쪽 화이트 초콜릿의 갯수는 계차수열을 이루게 됨
        1. 첫 층의 아래쪽 화이트 초콜릿의 갯수는 r * c
        2. 두번째 층의 아래쪽 화이트 초콜릿의 갯수는 (r-1) * (c-1)
        3. 둘의 차이는 -r -c +1
        4. r과 c는 각 층마다 1씩 줄어드므로 각 층의 차이의 차이는 2씩 감소하게 됨
        위쪽 화이트 초콜릿의 갯수는 같은 규칙이지만 한단계 이후
        다크 초콜릿의 갯수도 마찬가지로 규칙을 가진 수열의 형태로 표현 가능하며
        이는 일반항을 구하고 n번째 항까지의 합을 구하는게 가능하다는 의미

        다만 이 문제를 풀기에는 지금 시간이 모자름...
         */
    }
}
