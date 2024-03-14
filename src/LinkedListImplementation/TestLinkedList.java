package LinkedListImplementation;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.traverse();
        myLinkedList.addAtHead(1);


        myLinkedList.traverse();
        myLinkedList.addAtTail(3);
        myLinkedList.traverse();
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.traverse();
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.traverse();
        System.out.println(myLinkedList.get(1));              // return 3
    }
}
