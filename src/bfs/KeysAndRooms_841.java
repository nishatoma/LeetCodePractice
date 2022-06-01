package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class KeysAndRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        Arrays.fill(visited, 0);
        visited[0] = 1;

        Deque<Integer> q = new ArrayDeque<>();

        // process 0
        for (int key : rooms.get(0)) {
            if (visited[key] == 0) {
                visited[key] = 1;
                System.out.println("Room " + key + " freed from room 0");
                q.offer(key);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int key : rooms.get(v)) {
                if (visited[key] == 0) {
                    System.out.println("Room " + key + " freed from room " + v);
                    visited[key] = 1;
                    q.offer(key);
                }
            }
        }

        for (int i : visited) if (i == 0) return false;

        return true;
    }
}
