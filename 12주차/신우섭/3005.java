import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[r][c];

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                puzzle[i][j] = input[j].charAt(0);
            }
        }

        System.out.println(search(r, c, puzzle));

        br.close();
    }

    private static String search(int r, int c, char[][] puzzle) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                word.append(puzzle[i][j]);
            }
            word.append("#");
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                word.append(puzzle[j][i]);
            }
            word.append("#");
        }

        String[] words = word.toString().split("#");
        Arrays.sort(words);
        for (String str : words) {
            if (str.length() >= 2) return str;
        }
        return "";
    }
}
