class Solution {
    boolean arr[][];
    int max = 0;
    int gridlength = 0;
    public int maxAreaOfIsland(int[][] grid) {
        arr = new boolean[grid.length][grid[0].length];
        for(int i =0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && arr[i][j] == false){
                    gridlength = 0;  // for each cluseter inintial value for area is set to 0
                    dfs(grid,i,j,arr); // DFS search on cluster
                    if(gridlength > max){   //Check if it has maximum area
                        max = gridlength;
                    }
                }
            }
        }
        return max;
    }
    
    public void dfs(int grid[][], int i ,int j,boolean arr[][]){
        if(i < 0 || i >= grid.length || j <0 || j>= grid[0].length){
            return;
        }
        if(grid[i][j] == 1 && arr[i][j] == false){
            gridlength++;
            arr[i][j] = true;
            dfs(grid,i-1,j,arr); //Checking for 4 sides
            dfs(grid,i+1,j,arr);
            dfs(grid,i,j-1,arr);
            dfs(grid,i,j+1,arr);
        }
        
    }
}