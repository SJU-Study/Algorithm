import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c, max;
    static int[] sushi, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max = 0;

        sushi = new int[n];
        visited = new int[d + 1];   // 현재 선택된 초밥의 수
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        slide();
        System.out.println(max);
        br.close();
    }

    private static void slide() {
        int total = 0;
        for (int i = 0; i < k; i++) {   // 초기 세팅
            if (visited[sushi[i]] == 0) total++;
            visited[sushi[i]]++;
        }
        if (visited[c] == 0) max = total + 1;   // 쿠폰 초밥 포함
        else max = total;

        for (int i = 1; i < n; i++) {
            visited[sushi[i - 1]]--;    // 맨 앞 초밥 제거
            if (visited[sushi[i - 1]] == 0) total--;
            if (visited[sushi[(i + k - 1) % n]] == 0) total++;  // 맨 뒤 새로운 초밥 추가
            visited[sushi[(i + k - 1) % n]]++;
            
            if (max <= total) { // 초밥 가짓수 최댓값 갱신
                if (visited[c] == 0) max = total + 1;
                else max = total;
            }
        }
    }
}
