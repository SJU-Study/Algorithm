import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        BigInteger answer1 = new BigInteger("1");
        BigInteger answer2 = new BigInteger("1");

        for (int i = 0; i < m; i++) {
            answer1 = answer1.multiply(new BigInteger(String.valueOf(n - i)));
            answer2 = answer2.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(answer1.divide(answer2));
        br.close();
    }
}