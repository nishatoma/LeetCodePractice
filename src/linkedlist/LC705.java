package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LC705 {
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentList;

    public LC705() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        // Initialize lists here
        for (int i = 0; i < ARRAY_SIZE; ++i) {
            parentList.add(null);
        }
    }

    public void add(int key) {
        int index = key % ARRAY_SIZE;
        if (parentList.get(index) == null) {
            // initialize list first
            parentList.set(index, new ArrayList<>());
        }
        // Add to hte arraylist
        if (!contains(key)) {
            parentList.get(index).add(key);
        }
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        if (parentList.get(index) == null) {
            return;
        }
        parentList.get(index).remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        return (parentList.get(index) != null && parentList.get(index).contains(key));
    }
}
