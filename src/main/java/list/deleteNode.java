package list;

/**
 * @Classname deleteNode
 * @Description TODO
 * @Date 2020/2/7 10:32
 * @Created by zheng.nie
 */
public class deleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
