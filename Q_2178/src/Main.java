import java.io.*;
import java.util.*;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { 1, 0, -1, 0 };
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);

    }

    private static void bfs(int x, int y) {
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(x, y));
        while (!q.isEmpty()) {
            Dot d = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = d.x + dx[i];
                int nexty = d.y + dy[i];

                if (nextx < 0 || nexty < 0 || nextx >= N || nexty == M) {
                    continue;
                }
                if (visited[nextx][nexty] == true || arr[nextx][nexty] == 0) {
                    continue;
                }

                q.add(new Dot(nextx, nexty));
                arr[nextx][nexty] = arr[d.x][d.y] + 1;
                visited[nextx][nexty] = true;
            }
        }

    }
}

class Dot {
    int x;
    int y;

    Dot(int i, int j) {
        this.x = i;
        this.y = j;
    }
}