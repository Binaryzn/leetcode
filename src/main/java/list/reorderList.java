package list;


/**
 *    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reorderList {


    /**
     * 三步走
     *  1.找出链表的中间节点
     *  2.根据中间节点将链表分为两段
     *  3.右端链表翻转
     *  4.左右链表合并
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }

    }

}
