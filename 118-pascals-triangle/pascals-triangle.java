class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new ArrayList<>();

        for(int r = 0 ; r < numRows ; r++) {
            List<Integer> ansRow = new ArrayList<>();
            ansRow.add(1);

            for(int c = 1 ; c < r ; c++) {
                ansRow.add(ansList.get(r - 1).get(c - 1) + ansList.get(r - 1).get(c));
            }

            if(r > 0) {
                ansRow.add(1);
            }
            
            ansList.add(ansRow);
        }

        return ansList;
    }
}