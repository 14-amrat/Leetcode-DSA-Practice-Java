class Solution {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Step 1: build until >= b length
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Step 2: check
        if (sb.toString().contains(b)) {
            return count;
        }

        // Step 3: check one more repeat
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) {
            return count;
        }

        return -1;
    }
}