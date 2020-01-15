package list;


import java.util.List;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * [1,2,3,4,5]
 * 2
 * 4
 *
 *  [3,5]
 * 1
 * 2
 */
public class reverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        if(m == n){
            return head;
        }
        ListNode res = head;
        for (int i =1;i<m-1;i++){
            head = head.next;
        }
        ListNode l = head;
        head =head.next;
        ListNode r = head;
        ListNode pre = null;
        ListNode next = null;
        while (n-m>0){
            n--;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        l.next = pre;
        r.next = next;
        return res;
    }

}
