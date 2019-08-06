package com.Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                // System.out.println(i+" and "+j);
                if (visited.contains(i * m + j))
                    continue;
                if (grid[i][j] == '1') {
                    queue.offer(i * m + j);

                    //    System.out.println(i+" "+j);
                    count++;
                }
                visited.add(i * m + j);

                while (!queue.isEmpty()) {
                    Integer element = queue.poll();
                    int a = element / m;
                    int b = element % m;
                    //    System.out.println(element+": "+a+"|"+b);
                    //   System.out.println(visited);
                    if (a + 1 < grid.length && b < grid[0].length && !visited.contains((a + 1) * m + b)) {
                        if (grid[a + 1][b] == '1') {
                            queue.offer((a + 1) * m + b);
                        }
                        visited.add((a + 1) * m + b);
                    }

                    if (a < grid.length && b + 1 < grid[0].length && !visited.contains(a * m + (b + 1))) {
                        if (grid[a][b + 1] == '1') {
                            queue.offer(a * m + (b + 1));
                        }
                        visited.add(a * m + (b + 1));
                    }

                    if (a - 1 > -1 && b < grid[0].length && !visited.contains((a - 1) * m + b)) {
                        if (grid[a - 1][b] == '1') {
                            queue.offer((a - 1) * m + b);
                        }
                        visited.add((a - 1) * m + b);
                    }

                    if (a < grid.length && b - 1 > -1 && !visited.contains(a * m + (b - 1))) {
                        if (grid[a][b - 1] == '1') {
                            queue.offer(a * m + (b - 1));
                        }
                        visited.add(a * m + (b - 1));
                    }

                }

            }

        }
        //  System.out.println(visited);
        return count;
    }

    public static void main(String[] args) {
        char[][] input = {{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        System.out.println(new NumberOfIslands().numIslands(input));
    }
}
