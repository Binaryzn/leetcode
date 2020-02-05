package list;

/**
 * @Classname insertionSortList
 * @Description TODO
 * @Date 2020/2/5 12:18
 * @Created by zheng.nie
 * 辅助前继节点
 *  2 1 3
 */
public class insertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next  == null){
            return head;
        }
        ListNode dy = new ListNode(0);
        dy.next = head;
        ListNode pre;
        while (head != null && head.next != null){
            if(head.next.val > head.val){
                head = head.next;
                continue;
            }
            pre = dy;
            while (pre.next.val< head.next.val){
                pre = pre.next;
            }
            //插入节点
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dy.next;
    }

}
