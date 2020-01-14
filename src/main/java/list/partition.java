package list;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前
 * 你应当保留两个分区中每个节点的初始相对位置
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 *
 [1,4,3,2,5,2]
 3
 *
 */
public class partition {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        //小节点的首节点 用于连接分割后的两段节点
        ListNode min = new ListNode(-1);
        //大节点的首节点 连接时 使用大节点的next节点
        ListNode max = new ListNode(-1);
        //小节点链表的当前节点 用于连接小于x值
        ListNode f = min;
        //大节点的当前节点用于连接大于x值得节点
        ListNode r = max;
        while (head != null){
            if(head.val < x){
                f.next = head;
                //head节点用于遍历整个链表
                head = head.next;
                f = f.next;
                //符合x值得节点找到之后 将节点的next释放
                f.next = null;
            }else {
                r.next = head;
                head = head.next;
                r = r.next;
                r.next =null;
            }
        }
        f.next = max.next;
        return min.next;
    }

}
