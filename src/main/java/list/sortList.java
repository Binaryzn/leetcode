package list;

/**
 * @Classname sortList
 * @Description TODO
 * @Date 2020/2/5 16:09
 * @Created by zheng.nie
 */
public class sortList {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    ListNode mergeSort(ListNode head){
        if(head ==null || head.next == null){
            return head;
        }
        //找出中位切割点
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode r = mergeSort(slow.next);
        slow.next = null;
        ListNode l =  mergeSort(head);
        return mergerList(l,r);
    }


    private ListNode mergerList(ListNode l, ListNode r) {
        ListNode dy = new ListNode(-1);
        ListNode p = dy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return dy.next;
    }
}
