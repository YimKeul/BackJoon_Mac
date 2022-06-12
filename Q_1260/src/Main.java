import java.io.*;
import java.util.*;

public class Main {

    static int[][] check;
    static boolean[] checked;
    static int N;
    static int M;
    static int V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        check = new int[1001][1001];
        checked = new boolean[1001];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            check[a][b] = check[b][a] = 1;
        }

        dfs(V);
        checked = new boolean[1001];
        System.out.println();
        bfs();

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V);
        checked[V] = true;
        System.out.print(V + " ");
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (check[temp][i] == 1 && checked[i] == false) {
                    queue.offer(i);
                    checked[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static void dfs(int start) {
        checked[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
            if (check[start][i] == 1 && checked[i] == false) {
                dfs(i);
            }
        }
    }
}
