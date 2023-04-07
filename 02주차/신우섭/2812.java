import java.io.*;
import java.util.*;

public class Main {public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    String s = br.readLine();

    Stack<Integer> stack = new Stack<>();
    int cnt = k;
    for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(String.valueOf(s.charAt(i)));
        while (cnt > 0 && !stack.isEmpty() && stack.peek() < num) {
            stack.pop();
            cnt--;
        }
        if (stack.size() < n - k) {
            stack.add(num);
        }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
        sb.append(stack.pop());
    }
    System.out.println(sb.reverse());
    br.close();
}
}