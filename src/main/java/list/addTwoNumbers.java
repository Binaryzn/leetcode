package list;

import java.util.Stack;

/**
 * @Classname addTwoNumbers
 * @Description TODO
 * @Date 2020/2/7 11:19
 * @Created by zheng.nie
 */
public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            stack1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2.val);
            p2 = p2.next;
        }
        ListNode res = new ListNode(-1);
        ListNode listNode;
        Integer remain = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || remain > 0) {
            Integer value = 0;
            if (!stack1.isEmpty()) {
                value = value + stack1.pop();
            }
            if (!stack2.isEmpty()) {
                value = value + stack2.pop();
            }
            value = value + remain;
            remain = value / 10;
            listNode = new ListNode(value % 10);
            listNode.next = res.next;
            res.next = listNode;
        }
        return res.next;
    }

}
