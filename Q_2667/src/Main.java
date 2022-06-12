import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int apartnum = 0;
    static int[] aparts = new int[25 * 25];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    apartnum++;
                    bfs(i, j);

                }
            }

        }
        Arrays.sort(aparts);
        System.out.println(apartnum);
        for (int i = 0; i < aparts.length; i++) {
            if (aparts[i] == 0) {
            } else {
                System.out.println(aparts[i]);
            }

        }
    }

    private static void bfs(int x, int y) {
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(x, y));
        while (!q.isEmpty()) {
            Dot d = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = d.x + dx[i];
                int nexty = d.y + dy[i];

                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N) {
                    continue;
                }
                if (visited[nextx][nexty] == true || arr[nextx][nexty] == 0) {
                    continue;
                }

                q.add(new Dot(nextx, nexty));
                arr[nextx][nexty] = arr[d.x][d.y] + 1;
                visited[nextx][nexty] = true;
                aparts[apartnum]++;
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

// 7
// 0110100
// 0110101
// 1110101
// 0000111
// 0100000
// 0111110
// 0111000