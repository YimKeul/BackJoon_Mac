import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> list[];
    static int n;
    static int max = 0;
    static int max_idx = 0;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] t = br.readLine().split(" ");
            int parent = Integer.parseInt(t[0]);
            int child = Integer.parseInt(t[1]);
            int weight = Integer.parseInt(t[2]);

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);

        
        System.out.println(max);
    }

    private static void dfs(int idx, int cnt) {
        if (max < cnt) {
            max=cnt;
            max_idx = idx;
        }

        for (Node a : list[idx]) {
            if (!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, cnt + a.cnt);
            }
        }

    }

}

class Node {

    int idx, cnt;

    public Node(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;

    }
}