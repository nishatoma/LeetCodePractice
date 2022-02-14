package dsa.chapter3;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        char[] data = new char[]{'b', 'c', 'd', 'a', 'e', 'h', 'g', 'f'};

        insertionSort(data);

        System.out.println(Arrays.toString(data));
    }

    public static void insertionSort(char[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    swap(j, j - 1, data);
                }
            }
        }
    }

    static void swap(int i, int j, char[] data) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
