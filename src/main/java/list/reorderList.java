package list;


/**
 *    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reorderList {


    /** 1 2 3 4 5 6 7
     * 三步走
     *  1.找出链表的中间节点
     *  2.根据中间节点将链表分为两段
     *  3.右端链表翻转
     *  4.左右链表合并
     * @param head
     */
    public  void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }
        ListNode mid = getMidNode(head);
        System.out.println("------"+mid.val);
        //分割链表右侧链表
        ListNode right = mid.next;
        //分割链表
        mid.next = null;
        //
        ListNode left = head;
        ListNode resv = new ListNode(-1);
        resv.next = right;
        ListNode next = right.next;
        //翻转右侧链表   5 -6 7
        while ( next != null){
            right.next = right.next.next;
            next.next = resv.next;
            resv.next = next;
            next = right.next;
        }
        right = resv.next;
        //合并链表 1- 2-3->4    5 ->6->7
        ListNode leftTemp;
        ListNode rightTemp;
        while (left != null && right != null){
            leftTemp = left.next;
            rightTemp = right.next;
            left.next = right;
            right.next = leftTemp;
            left = leftTemp;
            right = rightTemp;
        }
    }
    // 1 -> 2->3->4->5
    //快慢指针找出中间节点
   private  ListNode getMidNode(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode head1 = new ListNode(2);
//        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(4);
//        ListNode head4 = new ListNode(5);
//        ListNode head5 = new ListNode(6);
//        ListNode head6 = new ListNode(7);
//        head.next = head1;
//        head1.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//        head4.next= head5;
//        head5.next = head6;
//        reorderList(head);
//        while (head != null){
//            System.out.println("res====="+head.val);
//            head = head.next;
//        }
//    }

}
