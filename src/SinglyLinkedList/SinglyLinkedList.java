package SinglyLinkedList;

public class SinglyLinkedList {
    public Node head;
    private Node tail;
    private int size;

    public Node create(int nodeValue){
//        head = new Node();
        Node node = new Node();
        node.next = null;
        node.val = nodeValue;
        head = node;
        tail = node;
        size = 1;

        return head;

    }



    public void insertNode(int nodeValue, int location){
        Node node = new Node();
        node.val = nodeValue;
        if(head == null){
            create(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >=size) {
            node.next = null;
            tail.next = node;
            tail = node;
        }else{
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = tempNode;
        }
        size++;
    }

    public void traverse(){
        if(head==null){
            System.out.println("Linked List does not exist.");
        }else{
            Node tempNode = head;
            while(tempNode != null){
                System.out.print(tempNode.val);
                if(tempNode.next!= null){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

}
