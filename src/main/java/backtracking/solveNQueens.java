package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class solveNQueens {


    private List<List<String>> ans = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {

        //默认为0 表示不放置皇后 为1表示放置皇后
        int[][] broad = new int[n][n];
        dfs(n, 0, broad);
        return ans;
    }


    public void dfs(int n, int row, int[][] broad) {
        //如果row 和 n相等  说明 一种情况已存在
        if (row == n) {
            ans.add(track(broad,n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSolve(broad, row, col)) {
                broad[row][col] = 1;
                dfs(n, row + 1, broad);
                //还原现场
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


    //将int类型棋盘转换成输出格式
    private List<String> track(int[][] board, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) temp.append('.');
                else temp.append('Q');
            }
            list.add(temp.toString());
        }
        return list;
    }


}
