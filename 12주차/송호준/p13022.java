import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.length() % 4 != 0) {
            System.out.println(0);
            return;
        }
        int eachLength = input.length() / 4;

        String[] d = new String[4];
        for (int i = 0; i < 4; i++) {
            d[i] = "";
        }
        for (int i = 0; i < eachLength; i++) {
            if (input.length() == 0) {
                break;
            }
            d[0] += 'w';
            d[1] += 'o';
            d[2] += 'l';
            d[3] += 'f';

            String str = d[0] + d[1] + d[2] + d[3];
            while (input.contains(str)) {
                input = input.replace(str, "*");
            }
        }
        input = input.replaceAll("[*]", "");
        if (input.length() == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
