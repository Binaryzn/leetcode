package backtracking;

public class totalNQueens {

    private int res = 0;

    public int totalNQueens(int n) {
        int[][] broad = new int[n][n];
        dfs(n, 0, broad);
        return res;
    }

    void dfs(int n, int row, int[][] broad) {
        //有一次成功 则计数器加1
        if (n == row) {
            System.out.println(111111);
            res = res + 1;
            return;
        }
        for (int col = 0; col < n; col++) {
            //判断是否满足N皇后 规则
            if (isSlave(broad, col, row)) {
                //放置标志位
                broad[row][col] = 1;
                //继续深度遍历
                dfs(n, row + 1, broad);
                //现场还原
                broad[row][col] = 0;
            }
        }
    }

    /**
     * 判断当前 row col 是否能放置皇后
     *
     * @param broad
     * @param row
     * @param col
     * @return
     */
    public boolean isSolve(int[][] broad, int row, int col) {
        //判断列上面是否有皇后，因为是按照row进行DFS的 所以要判断列
        for (int i = 0; i < row; i++) {
            if (broad[i][col] == 1) {
                return false;
            }
        }
        //判断左上角到右下角有没有皇后 右下---->左上
        for (int i = col - 1; i >= 0; i--) {
            if (i - col + row < 0) {
                break;
            }
            if (broad[i - col + row][i] == 1) {
                return false;
            }
        }
        //判断右上角到左下角有没有皇后  左下 ---->右上
        for (int j = col + 1; j < broad.length; j++) {
            if (row + col - j < 0) {
                break;
            }
            if (broad[row + col - j][j] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 同一列不能有 对角线不能有
     *
     * @param broad
     * @param col
     * @param row
     * @return
     */
    boolean isSlave(int[][] broad, int col, int row) {
        //先判断当前列能不能放，循环每一行
        for (int i = 0; i < row; i++) {
            if (broad[i][col] == 1) {
                return false;
            }
        }
        //判断左上到右下
        for (int i = col - 1; i >= 0; i--) {
            if ((row + i - col) < 0) {
                break;
            }
            if (broad[row + i - col][i] == 1) {
                return false;
            }
        }
        //判断右上到左下
        for (int i = col + 1; i < broad.length; i++) {
            if ((row + col - i) < 0) {
                break;
            }
            if (broad[row + col - i][i] == 1) {
                return false;
            }
        }
        return true;
    }


}
