package SinglyLinkedList;

public class Node {
    public int val;         // Actual Value
    public Node next;   // Pointer to next node
    public Node(){}

    public Node (int val, Node next){
        this.val = val;
        this.next = next;
    }
}
