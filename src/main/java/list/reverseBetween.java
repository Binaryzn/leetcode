package list;


import java.util.List;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * [1,2,3,4,5]
 * 2
 * 4
 * [1,4,3,2,5]
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
        //用于指向返回节点的pre节点
        ListNode l = new ListNode(-1);
        //永远指向要翻转链表的pre节点
        l.next = head;
        ListNode pre = l;
        for (int i =1;i<m;i++){
            pre = pre.next;
        }
        //1 2 3 4 5
        //1 3 2 4 5
        //1 4 3 2 5
        //每次找到head节点的netx节点 然后头插到pre节点后面
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return l.next;
    }


    public static void main(String[] args) {

    }

}
