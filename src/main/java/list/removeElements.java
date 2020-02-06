package list;

/**
 * @Classname removeElements
 * @Description TODO
 * @Date 2020/2/6 11:46
 * @Created by zheng.nie
 */
public class removeElements {

    public ListNode removeElements(ListNode head, int val) {
        //辅助节点
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p = res;
        while (p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else {
                p = p.next;

            }
        }

        return res.next;
    }

}
