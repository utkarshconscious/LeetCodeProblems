package com.topFifty;

public class SudokuSolver {
    private static int count =0;
    public static void solveSudoku(char[][] board) {

        char[][] tempBoard = new char[board.length][board[0].length];
        copyBoard(board, tempBoard);
        solveRecursively(0, 0, tempBoard, board);
        printBoard(tempBoard);
        System.out.println(count);

    }

    private static boolean solveRecursively(int row, int column, char[][] tempBoard, char[][] board) {
        if (row > 8 && column > 8) {
            count++;
            return validateBoard(tempBoard);
        }
        int nextRow = nextRow(row, column);
        int nextColumn = nextColumn(column, row);
        if (tempBoard[row][column] != '.') {
            return solveRecursively(nextRow, nextColumn, tempBoard, board);
        }
        for (int i = 1; i <= 9; i++) {
            if (validBoardEntry(row, column, i, tempBoard)) {
                tempBoard[row][column] = (char)(i+'0');
            }
            else{
                continue;
            }
            if (solveRecursively(nextRow, nextColumn, tempBoard, board)) {
                return true;
            }
            wipeBoard(nextRow, nextColumn, tempBoard, board);
        }
        return false;
    }

    private static int nextColumn(int column, int row) {
        if (row < 8 && column == 8) {
            column = 0;
        } else {
            column++;
        }
        return column;
    }

    private static int nextRow(int row, int column) {
        if (column >= 8) {
            row++;
        }
        return row;
    }

    private static void wipeBoard(int startRow, int startColumn, char[][] tempBoard, char[][] board) {
        for (int i = startColumn; i < 9; i++) {
            tempBoard[startRow][i] = board[startRow][i];
        }
        for (int i = startRow+1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
    }

    private static boolean validBoardEntry(int row, int column, int target, char[][] tempBoard) {
        return validRow(row, column, tempBoard, target) && validColumn(row, column, tempBoard, target) && validBox(row, column, tempBoard, target);
    }

    private static boolean validateBoard(char[][] tempBoard) {
        return ValidSudoku.isValidSudoku(tempBoard);
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void copyBoard(char[][] board, char[][] tempBoard) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
    }

    private static boolean validRow(int row, int column, char[][] board, int target) {
        boolean isValid = true;
        for (int i = 0; i < 9; i++) {
            if (i == column) {
                continue;
            }
            if (board[row][i] == target+'0') {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private static boolean validColumn(int row, int column, char[][] board, int target) {
        boolean isValid = true;
        for (int i = 0; i < 9; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][column] == target+'0') {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static boolean validBox(int row, int column, char[][] board, int target) {
        boolean isValid = true;
        int startRow = identifyStartingPos(row);
        int startColumn = identifyStartingPos(column);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (i == row && j == column) {
                    continue;
                }
                if (board[i][j] == target+'0') {
                    return false;
                }
            }
        }

        return isValid;
    }


    private static int identifyStartingPos(int i) {
        int startingPos = 0;
        if (i > 2 && i <= 5) {
            startingPos = 3;
        } else if (i > 5) {
            startingPos = 6;
        }
        return startingPos;
    }

    public static void main(String [] args){
//        char sudoku [][] = {{'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};
        char sudoku [][] = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};



        solveSudoku(sudoku);
    }
}
