package ds.MiscJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 02-07-2017.
 */
public class SystemInputOutput {

    public static void main(String a[]) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String line = br.readLine();
        //int N = Integer.parseInt(line);

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        List list = new ArrayList();
        s.nextLine();
        for (int i = 0; i < N - 1; i++) {
            String temp = s.nextLine();
            String[] str = temp.split(" ");
            list.add(Integer.parseInt(str[0]));
            list.add(str[1]);
        }
        int P = s.nextInt();
        s.nextLine();
        for (int i = 0; i < P; i++) {
            String temp = s.nextLine();
            String[] str = temp.split(" ");
            list.add(str[0]);
            list.add(str[1]);
        }
    }
}
