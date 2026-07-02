class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0; // pointer for children (greed)
        int j = 0; // pointer for cookies
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // this child is content, move to next child
            }
            j++; // move to next cookie regardless
        }
        
        return i; // i = count of content children
    }
}