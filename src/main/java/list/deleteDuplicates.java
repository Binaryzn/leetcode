package list;

/**
 * @Classname deleteDuplicates
 * @Description TODO
 * @Date 2020/1/13 22:06
 * @Created by zheng.nie
 */
public class deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if ((fast.next != null && fast.val != fast.next.val) || fast.next == null) {
                if (slow.next == fast) {
                    //没有重复节点的情况
                    slow = fast;
                } else {
                    //有重复节点的情况
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }
        return dummy.next;
    }

}
