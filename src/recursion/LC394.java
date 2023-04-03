package recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC394 {
    public String decodeString(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        return dfs(q);
    }

    private String dfs(Deque<Character> q) {
        StringBuilder sb = new StringBuilder();

        int repeat = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if ('0' <= c && c <= '9') {
                repeat = 10 * repeat + (c - '0');
            } else if (c == '[') {
                String str = dfs(q);
                for (int i = 0; i < repeat; ++i) {
                    sb.append(str);
                }
                repeat = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
