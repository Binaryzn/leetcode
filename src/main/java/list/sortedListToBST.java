package list;


/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *  1 2 3 4 5 6 7 8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



public class sortedListToBST {


    public TreeNode sortedListToBST(ListNode head) {

       if(head == null){
            return null;
       }
       if(head.next == null){
           return new TreeNode(head.val);
       }
       ListNode slow  = head.next;
       ListNode fast = head.next.next;
       ListNode pre = head;
       while (fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
           pre = pre.next;
       }
       //断链
       pre.next = null;
       TreeNode root = new TreeNode(slow.val);
       root.left = sortedListToBST(head);
       root.right = sortedListToBST(slow.next);
       return root;
    }

}
