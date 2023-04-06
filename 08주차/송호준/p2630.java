import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] arr;
    private static int blueCnt = 0;
    private static int whiteCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    arr[i][j] = true;
                }
            }
        }
        recurDivide(0, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void recurDivide(int startX, int startY, int N) {
        if (isAllBlue(startX, startY, N)) {
            blueCnt++;
            return;
        }
        if (isAllWhite(startX, startY, N)) {
            whiteCnt++;
            return;
        }
        N /= 2;
        recurDivide(startX, startY, N);
        recurDivide(startX + N, startY, N);
        recurDivide(startX, startY + N, N);
        recurDivide(startX + N, startY + N, N);

    }

    private static boolean isAllBlue(int startX, int startY, int N) {
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (!arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAllWhite(int startX, int startY, int N) {
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
