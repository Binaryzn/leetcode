package list;

/**
 * @Classname isPalindrome
 * @Description TODO
 * @Date 2020/2/6 16:43
 * @Created by zheng.nie
 */
public class isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时flow指向中间节点 //反转后半部分链表
        ListNode rev = new ListNode(1);
        rev.next = slow;
        while (slow.next != null){
            ListNode next = slow.next;
            slow.next  = next.next;
            next.next = rev.next;
            rev.next = next;
        }
        rev = rev.next;
        while (head != null && rev != null){
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

}
