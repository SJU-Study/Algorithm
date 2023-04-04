import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int s, e, q;
    static Set<String> before = new HashSet<>();
    static Set<String> after = new HashSet<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));
        e = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));
        q = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));

        checkAttendance();

        System.out.println(countStudent());
        br.close();
    }

    private static int countStudent() {
        int cnt = 0;
        for (String str : before) {
            if (after.contains(str)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void checkAttendance() throws IOException {
        StringTokenizer st;
        String chat;
        while ((chat = br.readLine()) != null) {
            st = new StringTokenizer(chat);
            int time = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));
            String name = st.nextToken();
            if (time <= s) {
                before.add(name);
            } else if (time >= e && time <= q) {
                after.add(name);
            }
        }
    }
}
