package twopointers;

public class FlippingAnImage_832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; ++i) {
            int left = 0;
            int right = image[0].length - 1;
            // traverse the column
            while (left <= right) {
                // swap first
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                // Then flip
                if (left < right) {
                    image[i][right--] ^= 1;
                }
                image[i][left++] ^= 1;
            }
        }
        return image;
    }
}
