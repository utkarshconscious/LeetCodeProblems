package com.topproblems;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/


import jdk.internal.util.xml.impl.Pair;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int charIndex = 0;
        boolean outcome = false;
        boolean finished = false;
        for (int i = 0; i < board.length && !finished; i++) {
            for (int j = 0; j < board[0].length; j++) {
                outcome = solveByBackTracking(charIndex, i, j, board, word, new HashSet<>());
                if (outcome) {
                    finished = true;
                    break;
                }
            }
        }
        return outcome;
    }

    private boolean solveByBackTracking(int charIndex, int row, int col, char[][] board, String word, Set<Pair> set) {
        if (board[row][col] == word.charAt(charIndex) && charIndex == word.length() - 1) {
            return true;
        } else if (board[row][col] != word.charAt(charIndex)) {
            return false;
        }
        boolean outcome = false;
        if (board[row][col] == word.charAt(charIndex)) {
            set.add(new Pair(row, col));
            if (col + 1 < board[0].length && !set.contains(new Pair(row, col + 1))) {
                outcome = solveByBackTracking(charIndex + 1, row, col + 1, board, word, set);
            }
            if (!outcome && row + 1 < board.length && !set.contains(new Pair(row + 1, col))) {
                outcome = solveByBackTracking(charIndex + 1, row + 1, col, board, word, set);
            }
            if (!outcome && col - 1 >= 0 && !set.contains(new Pair(row, col - 1))) {
                outcome = solveByBackTracking(charIndex + 1, row, col - 1, board, word, set);
            }
            if (!outcome && row - 1 >= 0 && !set.contains(new Pair(row - 1, col))) {
                outcome = solveByBackTracking(charIndex + 1, row - 1, col, board, word, set);
            }
        }
        if(!outcome){
            set.remove(new Pair(row, col));
        }
        return outcome;
    }


    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row && col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCEFSADEESE"));
    }
}
