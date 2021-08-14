package com.topFifty;

public class ValidSudoku {
    private static final int NINE = 9;

    public static boolean isValidSudoku(char[][] board) {
        int rowLength = 9;
        int columnLength = 9;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (board[i][j] != '.') {
                    boolean isValid = validateNumberPosition(i, j, board);
                    if (!isValid) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean validateNumberPosition(int row, int column, char[][] board) {
        return validRow(row, column, board) && validColumn(row, column, board) && validBox(row, column, board);
    }

    private static boolean validRow(int row, int column, char[][] board) {
        boolean isValid = true;
        char currNumber = board[row][column];
        for (int i = 0; i < NINE; i++) {
            if (i == column) {
                continue;
            }
            if (board[row][i] == currNumber) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private static boolean validColumn(int row, int column, char[][] board) {
        boolean isValid = true;
        char currNumber = board[row][column];
        for (int i = 0; i < NINE; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][column] == currNumber) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static boolean validBox(int row, int column, char[][] board) {
        boolean isValid = true;
        int startRow = identifyStartingPos(row);
        int startColumn = identifyStartingPos(column);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (i == row && j == column) {
                    continue;
                }
                if (board[i][j] == board[row][column]) {
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
//        char sudoku [][] = {{'5','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'2','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}};

        char sudoku [][] =  		{{'3','.','6','5','.','8','4','.','.'},
                {'5','2','.','.','.','.','.','.','.'},
                {'.','8','7','.','.','.','.','3','1'},
                {'.','.','3','.','1','.','.','8','.'},
                {'9','.','.','8','6','3','.','.','5'},
                {'.','5','.','.','9','.','6','.','.'},
                {'1','3','.','.','.','.','2','5','.'},
                {'.','.','.','.','.','.','.','7','4'},
                {'.','.','5','2','.','6','3','.','.'}};



        System.out.println(isValidSudoku(sudoku));
    }
}
