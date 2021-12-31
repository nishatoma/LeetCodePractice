package twopointers;

import java.util.ArrayDeque;
import java.util.Deque;

class BackspaceStringCompare_844 {
    // With O(N) Time and O(N) Space
    public boolean backspaceCompare(String s, String t) {

        char[] sChars = s.toCharArray();
        Deque<Character> s1 = new ArrayDeque<>();
        char[] tChars = t.toCharArray();
        Deque<Character> s2 = new ArrayDeque<>();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != '#') {
                s1.push(sChars[i]);
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            }
        }

        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] != '#') {
                s2.push(tChars[i]);
            } else {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            }
        }

        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }

        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }

        return true;
    }

    public boolean backspaceCompareConstantSpace(String s, String t) {

        int n = s.length() - 1;
        int m = t.length() - 1;
        int cnt1 = 0;
        int cnt2 = 0;

        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        while (n >= 0 || m >= 0) {

            while (n >= 0) {
                if (s.charAt(n) == '#') {
                    cnt1++;
                    n--;
                } else if (cnt1 > 0) {
                    cnt1--;
                    n--;
                } else {
                    break;
                }
            }

            while (m >= 0) {
                if (t.charAt(m) == '#') {
                    cnt2++;
                    m--;
                } else if (cnt2 > 0) {
                    cnt2--;
                    m--;
                } else {
                    break;
                }
            }

            if (n >= 0 && m >= 0 && s.charAt(n) != t.charAt(m)) {
                return false;
            }
            n--;
            m--;
        }
        return n == m;
    }
}