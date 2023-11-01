class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        //toggle and flip
        //if values at x and y are different and we flip and toggle we will end up with the same, eg, 0 1 -> 1 0 -> 0 1, so we will process only when values are same
        for(int i = 0; i < n; i++) {
            int x = 0; int y = n-1;
            while(x <= y) {
                if(image[i][x] == image[i][y] && x != y) {
                    //image[i][x] = 1-image[i][x];
                    image[i][x] ^= 1;
                    //image[i][y] = 1-image[i][y];
                    image[i][y] ^= 1;
                } else if (image[i][x] == image[i][y] && x == y) {
                    //image[i][x] = 1-image[i][x];
                    image[i][x] ^= 1;
                }
                x++;
                y--;
            }
        }
        return image;
    }
}