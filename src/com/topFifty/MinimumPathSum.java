package com.topFifty;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                minimumSum(grid, i, j);
            }
        }
        printBoard(grid);
        return grid[0][0];
    }

    private static void minimumSum(int[][] grid, int i, int j) {
        if (i < grid.length - 1 && j < grid[0].length - 1) {
            grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
        } else if (i < grid.length - 1) {
            grid[i][j] = grid[i][j] + grid[i + 1][j];
        } else if (j < grid[0].length - 1) {
            grid[i][j] = grid[i][j] + grid[i][j + 1];
        }
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
