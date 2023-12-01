package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob13305 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(reader.readLine());
        StringTokenizer cityDistToken = new StringTokenizer(reader.readLine());
        int[] cityDistance = new int[(int) (cityCount - 1)];
        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i] = Integer.parseInt(cityDistToken.nextToken());
        }

        StringTokenizer cityFuelToken = new StringTokenizer(reader.readLine());
        int[] cityFuel = new int[(int) cityCount];
        for (int i = 0; i < cityCount; i++) {
            cityFuel[i] = Integer.parseInt(cityFuelToken.nextToken());
        }

        int currentMin = Integer.MAX_VALUE;
        int needToGo = 0;
        int totalPrice = 0;
        for (int i = 0; i < cityCount - 1; i++) {
            // 현재 도시의 기름값이 여태까지 중 제일 싸다
            if (cityFuel[i] < currentMin) {
                // 여태까지 온 거리만큼 그 전까지 싼 도시에서 넣자.
                totalPrice += currentMin * needToGo;
                // 이제 여기가 제일 싸다.
                currentMin = cityFuel[i];
                // 여기서부터 출발해서 가야되는 거리
                needToGo = cityDistance[i];
            }
            // 예전이 더 싸다.
            else {
                // 여기서 더 가야된다.
                needToGo += cityDistance[i];
            }
        }

        return totalPrice + needToGo * currentMin;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob13305().solution());
    }
}
