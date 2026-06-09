class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> wrapList = new ArrayList<>();

        for(int i = 0 ; i < numRows ; i++) {
            List<Integer> innerList = new ArrayList<>();
            for(int j = 0 ; j < i + 1 ; j++) {
                if(j == 0 || j == i) innerList.add(1);
                else {
                    innerList.add(wrapList.get(i - 1).get(j - 1) + wrapList.get(i - 1).get(j));
                }
            }
            wrapList.add(new ArrayList<>(innerList));
        }  

        return wrapList;
    }
}