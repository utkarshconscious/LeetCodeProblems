package com.topFifty;
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//Each solution contains a distinct board configuration of the n-queens  placement,
//where 'Q' and '.' both indicate a queen and an empty space, respectively.

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> output = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        initializeBoard(chessBoard);

        solveRecursively(chessBoard, 0, output);

        return output;

    }

    private static void solveRecursively(char[][] chessBoard, int row, List<List<String>> output) {
        if (row == chessBoard.length) {
            convertBoardToListOfLists(chessBoard, output);
            return;
        }
        for (int i = 0; i < chessBoard[0].length; i++) {
            if (validPosition(row, i, chessBoard)) {
                chessBoard[row][i] = 'Q';
                solveRecursively(chessBoard, row + 1, output);
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

    private static void convertBoardToListOfLists(char[][] chessBoard, List<List<String>> output) {
        List<String> tempList = new ArrayList<>();
        StringBuilder builder;
        for (int i = 0; i < chessBoard.length; i++) {
            builder = new StringBuilder();
            for (int j = 0; j < chessBoard[0].length; j++) {
                builder.append(chessBoard[i][j]);
            }
            tempList.add(String.valueOf(builder));
        }
        output.add(tempList);
    }

    private static void initializeBoard(char[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j] = '.';
            }
        }
    }

    public static void main(String [] args){
        System.out.println(solveNQueens(5));
        System.out.println(solveNQueens(10).size());
    }
}
