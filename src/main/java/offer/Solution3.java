package offer;

import java.util.ArrayList;

/**
 * @author: niezheng
 * @create: 2021-01-13 19:21
 **/
public class Solution3 {

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;

    }

}
