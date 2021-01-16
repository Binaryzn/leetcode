package offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author: niezheng
 * @create: 2021-01-16 14:22
 **/
public class Solution4 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return rebuild(pre, in, 0, pre.length - 1, 0, in.length - 1);

    }

    //[1,2,4,3,5,6],[4,2,1,5,3,6]

    public TreeNode rebuild(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        if(preStart == preEnd){
            return new TreeNode(pre[preStart]);
        }
        if (inStart == inEnd) {
            return new TreeNode(in[inStart]);
        }
        TreeNode treeNode = new TreeNode(pre[preStart]);
        int root = pre[preStart];
        int start;
        for (start = inStart; start < inEnd; start++) {
            if (in[start] == root) {
                break;
            }
        }
        treeNode.left = rebuild(pre, in, preStart + 1, start - inStart + preStart, inStart,
                start - 1);
        treeNode.right = rebuild(pre, in, start - inStart + preStart + 1, preEnd, start + 1, inEnd);
        return treeNode;
    }


}
