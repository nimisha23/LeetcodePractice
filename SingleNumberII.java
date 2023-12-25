class Solution {
    public int singleNumber(int[] nums) {
        //modulu 3 addition
        int loner = 0;
        for(int i = 0; i < 32; i++) {
            int bit = 0;
            for(int n : nums) {
                //bit += (1 << i) & n;
                bit += (n >> i) & 1;
            }
            System.out.println(bit);
            int lonerBit = bit % 3;
            loner = loner | (lonerBit << i);
        }
        return loner;
    }
}