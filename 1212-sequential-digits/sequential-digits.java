class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String helper = "123456789";
        List<Integer> res = new ArrayList<>();

        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        for(int len = minLen ; len <= maxLen ; len++) {
            for(int start = 0 ; start + len <= 9 ; start++) {
                int num = Integer.parseInt(helper.substring(start, start + len));

                if(num >= low && num <= high) res.add(num);
            }
        }

        return res;
    }
}