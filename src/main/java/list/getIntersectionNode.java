package list;

/**
 * @Classname getIntersectionNode
 * @Description TODO
 * @Date 2020/2/6 11:37
 * @Created by zheng.nie
 * 两个链表分别指向 相反链表的开头
 */
public class getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA.next == null ? headB: pA.next;
            pB = pB.next == null ?  headA:pB.next;
        }
        return pA;
    }

}
