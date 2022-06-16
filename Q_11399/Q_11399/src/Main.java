import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        Collections.sort(list);

        int result = list.get(0);
        for (int i = 1; i < n; i++) {
            int data = list.get(i) + list.get(i - 1);
            list.set(i, data);

            result += data;
        }
        System.out.println(result);
    }
}
