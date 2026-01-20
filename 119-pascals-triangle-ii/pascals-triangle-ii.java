class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        long ans = 1;
        result.add((int) ans);

        for(int col = 1 ; col <= rowIndex ; col++) {
            ans = ans * (rowIndex - col + 1) / col;
            result.add((int) ans);
        }

        return result;
    }
}