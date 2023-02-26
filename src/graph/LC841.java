package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class LC841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Set<Integer> visited = new HashSet<>();
        // visited.add(0);
        // dfs(rooms, rooms.get(0), visited);
        // // For each room now, check visited
        // for (int i = 0; i < rooms.size(); ++i) {
        //     if (!visited.contains(i)) return false;
        // }
        // return true;
        return bfs(rooms);
    }

    // Runtime is O(V + E)
    private void dfs(List<List<Integer>> rooms, List<Integer> room, Set<Integer> visited) {
        for (int key : room) {
            if (visited.contains(key)) continue;
            visited.add(key);
            dfs(rooms, rooms.get(key), visited);
        }
    }

    private boolean bfs(List<List<Integer>> rooms) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        boolean[] visited = new boolean[rooms.size()];
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                int curr = q.poll();
                visited[curr] = true;

                for (int key : rooms.get(curr)) {
                    if (!visited[key]) {
                        q.offer(key);
                    }
                }
            }
        }
        for (int i = 0; i < rooms.size(); ++i) {
            if (!visited[i]) return false;
        }

        return true;
    }
}
