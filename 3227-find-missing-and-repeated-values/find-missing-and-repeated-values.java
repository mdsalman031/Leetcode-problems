class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // MATH :
        // x = missing number. y = repeated number

        // Sum equation:
        // Sum_actual - Sum_expected = y - x -------- eq1

        // Sum of squares equation :
        // sum_actual_square - sum_expected_square = y^2 - x^2 = (y - x)(y + x) 
        // eq2 = (y-x)(y+x) / (y-x)

        int size = grid.length;
        int n = size * size;
        long sum_actual = 0;
        long sum_expected = (long) (n * (n + 1) / 2);

        long sum_actual_square = 0;
        long sum_expected_square = (long) (n*(n + 1)*(2L*n + 1)) / 6;

        for(int i = 0 ; i < size ; i++) {
            for (int num : grid[i]) {
                sum_actual += num;
                sum_actual_square += (long) num * num;
            }
        }

        long eq1 = sum_actual - sum_expected;
        long eq2 = (sum_actual_square - sum_expected_square) / eq1;

        // Solving both equations
        long y = (eq1 + eq2) / 2;
        long x = eq2 - y;

        return new int[]{(int) y,(int) x};
    }
}