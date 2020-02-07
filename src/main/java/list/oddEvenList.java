package list;

/**
 * @Classname oddEvenList
 * @Description TODO
 * @Date 2020/2/7 10:41
 * @Created by zheng.nie
 */
public class oddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode res = head.next;
        // 1 2 3 4 5 6 7 8 9
        while (p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = res;
        return head;
    }

}
