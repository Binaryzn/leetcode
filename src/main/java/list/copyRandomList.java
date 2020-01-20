package list;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class copyRandomList {

    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        //第一步，先加节点 A -> B -> C  ----- A->A`->B->B`->C`
        Node node = head;
        while (node != null){
            Node clone = new Node(node.val);
            clone.next = node.next;
            node.next = clone;
            node = node.next.next;
        }
        node = head;
        while (node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
                //A`
        //A  ->-B->B`->C->C`
        Node res = node.next;
        while (node != null){
            Node  node1 = node.next;
            if(node.next.next == null){
                node.next = null;
            }else {
                node.next = node.next.next;
                node1.next = node1.next.next;
            }
            node = node.next;
        }
        return res;
    }

}
