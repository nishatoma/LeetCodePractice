package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        // Do DFS on the first room
        dfs(0, rooms, set);
        // If we visited all rooms, the size of our set
        // will contain all the rooms
        return (set.size() == rooms.size());
    }

    // Go with each room, find keys in it, and then for each key find its room and
    // visit it and so on...
    private void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(room);
        // For each key in the room
        for (int key : rooms.get(room)) {
            if (!visited.contains(key)) {
                dfs(key, rooms, visited);
            }
        }
    }
}
