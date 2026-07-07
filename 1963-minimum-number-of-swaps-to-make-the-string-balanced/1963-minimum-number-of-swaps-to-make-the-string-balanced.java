class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int unmatchedClose = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '[') {
                open++;
            } else {

                if (open > 0)
                    open--;
                else
                    unmatchedClose++;
            }
        }

        return (unmatchedClose + 1) / 2;
    }
}