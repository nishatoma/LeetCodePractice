package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permuteList("abc", ""));
        System.out.println(permute("abc", "", new ArrayList<>()));
        permute("abc", "");
        System.out.println(countPerms("abcdefghij"));
    }


    static List<String> permute(String abc, String res, List<String> ans) {

        if (abc.isEmpty()) {
            ans.add(res);
            return ans;
        }

        char ch = abc.charAt(0);

        for (int i = 0; i <= res.length(); i++) {
            String first = res.substring(0, i);
            String second = res.substring(i);

            permute(abc.substring(1), first + ch + second, ans);
        }

        return ans;
    }

    static void permute(String abc, String res) {

        if (abc.isEmpty()) {
            System.out.println(res);
            return;
        }
        char ch = abc.charAt(0);

        for (int i = 0; i <= res.length(); i++) {
            String first = res.substring(0, i);
            String second = res.substring(i);

            permute(abc.substring(1), first + ch + second);
        }
    }

    static List<String> permuteList(String abc, String res) {

        if (abc.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(res);
            return ans;
        }

        char ch = abc.charAt(0);
        List<String> finalList = new ArrayList<>();
        for (int i = 0; i <= res.length(); i++) {
            String first = res.substring(0, i);
            String second = res.substring(i);

            finalList.addAll(permuteList(abc.substring(1), first + ch + second));
        }

        return finalList;
    }

    static int countPerms(String abc) {
        if (abc.length() <= 1){
            return 1;
        }

        return abc.length() * countPerms(abc.substring(1));
    }
}
