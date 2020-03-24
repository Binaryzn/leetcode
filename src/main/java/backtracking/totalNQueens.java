package backtracking;

public class totalNQueens {

    private int res = 0;

    public int totalNQueens(int n) {
        int[][] broad = new int[n][n];
        dfs(n,0,broad);
        return res;
    }

    void dfs(int n,int row,int[][] broad){
        //有一次成功 则计数器加1
        if(n == row){
            res++;
            return;
        }
        for (int col = 0;col<n;col++){
            //判断是否满足N皇后 规则
            if(isSlave(broad,col,row)){
                //放置标志位
                broad[row][col] =1;
                //继续深度遍历
                dfs(n,row+1,broad);
                //现场还原
                broad[row][col] = 0;
            }
        }
    }

    /**
     *    同一列不能有 对角线不能有
     * @param broad
     * @param col
     * @param row
     * @return
     */
    boolean isSlave(int[][] broad,int col,int row){
        //先判断当前列能不能放，循环每一行
        for (int i =0;i<row;i++){
            if(broad[row][col] == 1){
                return false;
            }
        }
        //判断左上到右下
        for (int i = col-1;i>=0;i--){
            if((row+i-col) <0){
                break;
            }
            if(broad[row+i-col][i] == 1){
                return false;
            }
        }
        //判断右上到左下
        for (int i = col+1;i<broad.length;i++){
            if((row+col-i) <0){
                break;
            }
            if(broad[row+col-i][i] == 1){
                return false;
            }
        }
        return true;
    }


}
