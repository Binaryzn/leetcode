package list;

/**
 * @Classname splitListToParts
 * @Description TODO
 * @Date 2020/2/9 9:21
 * @Created by zheng.nie
 */
public class splitListToParts {


    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) {
            return res;
        }
        ListNode head = root;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        System.out.println(length);
        //多少个k个节点的链表
        int count = length / k;
        System.out.println(count);
        int remain = length % k;
        System.out.println(remain);
        ListNode cur = root;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            //计算是否加上余数
            int listSize = count + (remain-- > 0 ? 1 : 0);
            for (int j = 0; j < listSize- 1; j++) {
                cur = cur.next;
            }
            //断链
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

}
