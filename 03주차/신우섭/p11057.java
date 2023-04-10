import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][10];

        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    arr[i][j] += (arr[i - 1][k] % 10_007);
                }
                if (i == n - 1) cnt += (arr[i][j] % 10_007);
            }
        }

        System.out.println(n == 1 ? 10 : cnt % 10_007);
        br.close();
    }
}