package com.topFifty;

//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//Given an integer n, return the number of distinct solutions to the n-queens puzzle.

import java.util.ArrayList;
import java.util.List;



// DO THIS PROBLEM USING CHESSBOARD 2D ARRAY OF BOOLEAN TYPE.
public class NQueensProblemII {

    private static int counter = 0;
    public static int totalNQueens(int n) {
        counter = 0;
        char[][] chessBoard = new char[n][n];
        initializeBoard(chessBoard);
        solveRecursively(chessBoard, 0);
        return counter;

    }

    private static void solveRecursively(char[][] chessBoard, int row) {
        if (row == chessBoard.length) {
            counter++;
        }
        for (int i = 0; i < chessBoard[0].length; i++) {
            if (validPosition(row, i, chessBoard)) {
                chessBoard[row][i] = 'Q';
                solveRecursively(chessBoard, row + 1);
                chessBoard[row][i] = '.';
            }
        }
    }

    private static boolean validPosition(int row, int colStart, char[][] chessBoard) {
        int i = row, j = colStart;
        while (--i>= 0 && --j >= 0) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        i = row;
        j = colStart;
        while (--i>= 0  && ++j < chessBoard.length) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        i = row;
        while (--i >= 0) {
            if (chessBoard[i][colStart] == 'Q') {
                return false;
            }
        }
        return true;

    }

    private static void initializeBoard(char[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j] = '.';
            }
        }
    }

    public static void main(String [] args){
        System.out.println(totalNQueens(10));
    }
}
