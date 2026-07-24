class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char cell = board[r][c];

                if (cell == '.') continue;

                int d = cell - '1';           // 0-indexed digit (0-8)
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][d] || cols[c][d] || boxes[boxIndex][d]) {
                    return false;             // duplicate found
                }

                rows[r][d] = true;
                cols[c][d] = true;
                boxes[boxIndex][d] = true;
            }
        }

        return true;
    }
}