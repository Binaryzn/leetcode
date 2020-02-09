package recursion;

/**
 * @Classname longestUnivaluePath
 * @Description TODO
 * @Date 2020/2/9 15:42
 * @Created by zheng.nie
 */
public class longestUnivaluePath {

    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        //定义返回值
        ans = 0;
        getMaxLen(root);
        return ans;
    }

    private int getMaxLen(TreeNode node) {
        //递归出口
        if (node == null) {
            return 0;
        }
        int left = getMaxLen(node.left);
        int rigth = getMaxLen(node.right);
        //用于返回左链表 右链表长度 node节点和next不相等时返回0
        int leftAns = 0, rightAns = 0;
        if (node.left != null && node.val == node.left.val) {
            leftAns = left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            rightAns = rigth + 1;
        }
        //此处时最长路径 leftAns+rightAns;
        ans = Math.max(ans, leftAns + rightAns);
        //此函数每次返回但路径最大长度
        return Math.max(leftAns, rightAns);
    }

}
