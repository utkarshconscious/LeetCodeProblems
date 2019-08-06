package com.Queue;

public class NumberOfIslandsDFS {

    public int numIslandsDFS(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    DFS(i,j,grid,visited);
                    count++;
                }

            }
        }
            return count;
    }

    private boolean isSafeOperation(int row,int col,char[][] grid,boolean[][] visited){
        int ROW=grid.length;
        int COL=grid[0].length;

        if((row<0||row>=ROW||col<0||col>=COL)||visited[row][col]||grid[row][col]=='0')
            return false;

        return true;
    }

    private void DFS(int row,int col,char[][] grid,boolean[][] visited){
        visited[row][col]=true;
        int rowNbr [] ={-1,-1,-1, 0,+1,+1,+1,0};
        int colNbr [] ={-1, 0,+1,+1,+1, 0,-1,0};

        for(int k=0;k<8;k++){
            if(isSafeOperation(row+rowNbr[k],col+colNbr[k],grid,visited)){
                DFS(row+rowNbr[k],col+colNbr[k],grid,visited);
            }
        }
    }

    public static void main(String[] args) {
        char[][] input = {{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        System.out.println(new NumberOfIslandsDFS().numIslandsDFS(input));
    }
}
