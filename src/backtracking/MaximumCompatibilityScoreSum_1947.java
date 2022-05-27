package backtracking;

public class MaximumCompatibilityScoreSum_1947 {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] v = new boolean[students.length];

        return dfs(students, mentors, 0, v);
    }

    private int dfs(int[][] s, int[][] m, int pos, boolean[] v) {
        if (pos >= s.length) {
            return 0;
        }

        int max = 0;
        int currScore = 0;
        for (int i = 0; i < m.length; ++i) {
            if (!v[i]) {
                v[i] = true;
                // Get score between student and teacher
                currScore = getC(s[pos], m[i]) + dfs(s, m, pos + 1, v);
                v[i] = false;
                max = Math.max(max, currScore);
            }
        }


        return max;
    }


    private int getC(int[] student, int[] teacher) {
        int res = 0;

        for (int i = 0; i < student.length; ++i) {
            if (student[i] == teacher[i]) res++;
        }

        return res;
    }
}
