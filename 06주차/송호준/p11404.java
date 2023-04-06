import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[][] dist; //첫 번째 인덱스에서 두 번째 인덱스로 가는 최소 길이

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 9900001;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }
        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 9900001) {
                    sb.append("0");
                } else {
                    sb.append(dist[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}