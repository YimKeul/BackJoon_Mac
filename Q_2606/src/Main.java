import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static boolean visited[];
    static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        arr = new int[C];
        visited = new boolean[C];
        for (int i = 1; i <= C; i++) {
            arr[i - 1] = i;
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            bfs(a, b);
        }

    }

    private static void bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, b));
        while (!q.isEmpty()) {
            for (int i = 0; i < C; i++) {

            }
        }
    }

}

class Node {
    int root;
    int child;

    Node(int i, int j) {
        this.root = i;
        this.child = j;
    }
}
