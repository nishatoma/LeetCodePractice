package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    public static void main(String[] args) {
        List<String> res = subsequence("abc", "", new ArrayList<>());
        System.out.println(res);
        System.out.println("=========================================");
        res = subsequenceList("abc", "");
        System.out.println(res);
        System.out.println("=========================================");
        subsequenceAscii("abc", "");
        System.out.println("=========================================");
        res = subsequenceAsciiList("abc", "");
        System.out.println(res);
    }


    static void subsequence(String str, String res) {
        if (str.isEmpty()) {
            System.out.println(res);
            return;
        }

        char ch = str.charAt(0);

        subsequence(str.substring(1), res + ch);
        subsequence(str.substring(1), res);
    }

    static ArrayList<String> subsequence(String str, String comb, ArrayList<String> res) {
        if (str.isEmpty()) {
            res.add(comb);
            return res;
        }

        char ch = str.charAt(0);

        subsequence(str.substring(1), comb + ch, res);
        subsequence(str.substring(1), comb, res);

        return res;
    }

    static ArrayList<String> subsequenceList(String str, String comb) {
        if (str.isEmpty()) {
            ArrayList<String> res = new ArrayList<String>();
            res.add(comb);
            return res;
        }

        char ch = str.charAt(0);

        ArrayList<String> left = subsequenceList(str.substring(1), comb + ch);
        ArrayList<String> right = subsequenceList(str.substring(1), comb);
        left.addAll(right);

        return left;
    }

    static void subsequenceAscii(String str, String res) {
        if (str.isEmpty()) {
            System.out.println(res);
            return;
        }

        char ch = str.charAt(0);

        subsequenceAscii(str.substring(1), res + ch);
        subsequenceAscii(str.substring(1), res);
        subsequenceAscii(str.substring(1), res + (ch + 0));
    }

    static ArrayList<String> subsequenceAsciiList(String str, String comb) {
        if (str.isEmpty()) {
            ArrayList<String> res = new ArrayList<String>();
            res.add(comb);
            return res;
        }

        char ch = str.charAt(0);

        ArrayList<String> left = subsequenceAsciiList(str.substring(1), comb + ch);
        ArrayList<String> right = subsequenceAsciiList(str.substring(1), comb);
        ArrayList<String> ascii = subsequenceAsciiList(str.substring(1), comb + (ch + 0));
        left.addAll(right);
        left.addAll(ascii);

        return left;
    }
}
