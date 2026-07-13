class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String helper = "123456789";
        List<Integer> res = new ArrayList<>();

        int numDigits = (int) Math.log10(low) + 1;

        for(int i = 0 ; i < 10 ; i++) {
            for(int j = numDigits + i ; j < 10 ; j++) {
                int num = Integer.parseInt(helper.substring(i, j));
                if(num < low) continue;
                if(num > high) break;
                res.add(num);
            }
        }

        Collections.sort(res);

        return res;
    }
}