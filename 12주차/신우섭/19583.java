import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s, e, q;
    static Set<String> before = new HashSet<>();
    static Set<String> after = new HashSet<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = st.nextToken().replaceAll("[:]", "");
        e = st.nextToken().replaceAll("[:]", "");
        q = st.nextToken().replaceAll("[:]", "");

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
            String time = st.nextToken().replaceAll("[:]", "");
            String name = st.nextToken();
            if (time.compareTo(s) <= 0) {
                before.add(name);
            } else if (time.compareTo(e) >= 0 && time.compareTo(q) <= 0) {
                after.add(name);
            }
        }
    }
}
