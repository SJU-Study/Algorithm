import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N];
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int lionCnt = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            String k = st.nextToken();
            if (k.equals("1")) {
                arr[i] = true;
                lionCnt++;
                if (lionCnt == 1) {
                    left = i;
                    right = i;
                }
            }
        }
        if (lionCnt < K) {
            System.out.println(-1);
            return;
        }

        /*
         *   한칸씩 이동할건데
         *   먼저 right가 이동해
         *   K개 만큼 되버리면
         *   그 때 최소인지 계산 한번 때려
         *   그리고 K=2인 마지막 left 까지 이동해
         *   그다음 right 똑같이 가
         *
         * */

        int cnt = 0;
        while (right < N) {
            if (arr[right]) {
                cnt++;
                if (cnt == K) {
                    min = Math.min(min, right - left + 1);
                    if (min == K) {
                        System.out.println(min);
                        return;
                    }
                    left++;
                    while (left <= right && !arr[left]) {
                        left++;
                    }
                    cnt--;
                }
            }
            right++;
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
