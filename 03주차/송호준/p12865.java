import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int[] dp = new int[K + 1]; //index 까지의 최대 무게
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = K; j - W[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
                //  for (int j = W[i]; j <= K; j++)
                //      dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]); 이건 왜 안돼?
                //j번째 = j-W[i] 번째에 i를 넣는 경우
                //뒤에서부터 와야 함(앞에서부터 오면 답 틀림)
                //
            }
        }
        int max = 0;
        for (int e : dp) {
            max = Math.max(max, e);
        }
        System.out.println(max);

    }
}