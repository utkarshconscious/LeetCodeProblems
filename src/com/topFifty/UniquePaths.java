package com.topFifty;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
     //   return findCountOfUniquePathsRecursively(0, 0, m - 1, n - 1);
        return findCountOfUniquePathsDP(m, n);
    }

    private static int findCountOfUniquePathsRecursively(int m, int n, int maxM, int maxN) {
        if (m == maxM && n == maxN) {
            return 1;
        }
        int sum = 0;
        if (m < maxM) {
            sum += findCountOfUniquePathsRecursively(m + 1, n, maxM, maxN);
        }
        if (n < maxN) {
            sum += findCountOfUniquePathsRecursively(m, n + 1, maxM, maxN);
        }
        return sum;
    }

    private static int findCountOfUniquePathsDP(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }

        }
        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

}
