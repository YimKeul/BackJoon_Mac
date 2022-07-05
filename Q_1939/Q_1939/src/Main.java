import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Island>> list = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        int max = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Island(b, c));
            list.get(b).add(new Island(a, c));

            max = Math.max(max, c);

        }

        right = max;

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2;
            visit = new boolean[n + 1];
            if (bfs(start, end, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static boolean bfs(int start, int end, int mid) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int island = q.poll();

            if (island == end) {
                return true;
            }

            for (Island i : list.get(island)) {
                if (!visit[i.destination] && mid <= i.cost) {
                    visit[i.destination] = true;
                    q.add(i.destination);
                }
            }
        }
        return false;
    }
}

class Island {
    int destination, cost;

    public Island(int d, int c) {
        this.destination = d;
        this.cost = c;
    }

}
