class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int bitFlips = 0;
        while(xor != 0) {
            xor = xor & (xor - 1);
            bitFlips++;
        }
        return bitFlips;
    }
}