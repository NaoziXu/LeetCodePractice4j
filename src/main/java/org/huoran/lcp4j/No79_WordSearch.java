package org.huoran.lcp4j;

/**
 * Created by Naozi on 2017/6/26.
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class No79_WordSearch {
    private static int[][] history;

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        history = new int[board.length][board[0].length];
        boolean success = false;
        for(int m = 0;m < board.length;m++){
            for(int n = 0;n < board[0].length;n++){
                if(chars[0] == board[m][n]){
                    success = check(board,chars,1,m,n);
                    if(success){
                        return success;
                    }
                }
            }
        }
        return success;
    }

    private static boolean check(char[][] board, char[] chars, int index, int i, int j){
        /**
         * set history
         * DO NOT USE .clone() !!!
         */
        history[i][j] = 1;

        // end
        if(index >= chars.length){
            return true;
        }

        // up
        if(charCanUse(board,chars[index],i-1,j)){
            boolean success = check(board,chars,index+1,i-1,j);
            if(success){
                return true;
            }
        }
        // down
        if(charCanUse(board,chars[index],i+1,j)){
            boolean success = check(board,chars,index+1,i+1,j);
            if(success){
                return true;
            }
        }
        // left
        if(charCanUse(board,chars[index],i,j-1)){
            boolean success = check(board,chars,index+1,i,j-1);
            if(success){
                return true;
            }
        }
        // right
        if(charCanUse(board,chars[index],i,j+1)){
            boolean success = check(board,chars,index+1,i,j+1);
            if(success){
                return true;
            }
        }

        // reset history
        history[i][j] = 0;

        // failed
        return false;
    }

    private static boolean charCanUse(char[][] board, char c, int i, int j){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
            if(history[i][j] != 1 && board[i][j] == c){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','E','S'};
        board[2] = new char[]{'A','D','E','E'};
        boolean result = exist(board,"ABCESEEEFS");
        System.out.println(result);
    }
}
