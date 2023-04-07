import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<String> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            if (isVPS(arr)) {
                bw.write("YES\n");
            }
            else{
                bw.write("NO\n");
            }
            stack.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isVPS(String[] arr) {
        for (int j = 0; j < arr.length; j++) {
            switch (arr[j]){
                case "(":
                    stack.push("(");
                    break;
                case ")":
                    if(!stack.isEmpty()) stack.pop();
                    else return false;
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}