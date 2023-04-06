import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        p[0] = 0;
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = p[i];
            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i - j] + dp[j], dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}