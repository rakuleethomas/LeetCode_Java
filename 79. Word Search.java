/* 79. Word Search */
class Solution {
    
    private char[][] board;
    private int ROWS;
    private int COLS;
    public boolean exist(char[][] board, String word) {
        
        int w = board[0].length;
        int h = board.length;
        Boolean[][] check = new Boolean[h][w];
        
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        
        
        for(int row = 0; row < this.ROWS; ++row){
            for(int col = 0; col < this.COLS; ++col){
                if(this.backTrack(row, col, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    private boolean backTrack(int row, int col, String word, int idx){
        /* check the bottom case */
        if(idx >= word.length()){
            return true;
        }
        
        
        // check boundaries
        if(row < 0 || row == this.ROWS || col < 0 || col == this.COLS 
           || this.board[row][col] != word.charAt(idx)){
            return false;
        }
        
        
        
        // mark the path before the next exploration
        this.board[row][col] = '@'; // dummy letter for marking
        
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        
        for(int d=0; d<4; ++d){
            if(this.backTrack(row + rowOffsets[d], col + colOffsets[d], word, idx + 1)){
                return true;
            }
        }
        
        // clean up and return the result
        this.board[row][col] = word.charAt(idx);
        return false;
        
    }
}