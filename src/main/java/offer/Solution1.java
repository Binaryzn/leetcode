package offer;

/**
 * @author: niezheng
 * @create: 2021-01-11 22:13
 **/
public class Solution1 {

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        //行数
        int row = array.length;
        //列数
        int col = array[0].length;
        //先从左下角开始对比 如果比左下角大 像右边遍历  如果比左下角小 像左上遍历
        int i = 0;
        int j = row - 1;
        while (i < col && j >= 0) {
            if (array[j][i] == target) {
                return true;
            } else if (array[j][i] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
