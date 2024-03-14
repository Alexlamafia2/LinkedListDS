package LinkedListImplementation;

import SinglyLinkedList.Node;

public class MyLinkedList {
    private ListNode head;
    private int size;
    private ListNode tail;

    public MyLinkedList(){

    }

    public int get(int index) {
        if(head == null) return -1;

        if (index <= 0) index = 0;
        if(index == 0){
            return head.val;
        }else if(index > size - 1){
            return -1;
        }else{
            ListNode dummy = head;
            for(int i =0; i<index;i++){
                dummy = dummy.next;
            }
            return dummy.val;
        }

    }

    public void addAtHead(int val){
        addAtIndex(0,val);
    }

    public void addAtTail(int val){
        addAtIndex(size-1,val);
    }

    public void addAtIndex(int index, int val){
        ListNode node = new ListNode();
        node.val = val;


        if(head == null){
            node.next = null;
            head = node;
            tail = node;
            size= 1;
        }else if(index==0){
            node.next = head;
            head=node;
        } else if (index >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        }else{
            ListNode dummy = head;
            for(int i = 0; i<index-1;i++){
                dummy = dummy.next;
            }
            node.next = dummy.next;
            dummy.next = node;
        }
        size++;
    }

    public void deleteAtIndex(int index){
        if(head == null){
            System.out.println("The LL does not exist");
            return;
        }else if(index == 0){
            head = head.next;
            if(size == 0){
                tail = null;
            }
        }else if(index >= size){
            ListNode dummy = head;
            for(int i = 0; i < size - 1; i++){
                dummy = dummy.next;
            }
            if(dummy==head){
                head = tail = null;
            }
            dummy.next = null;
            tail = dummy;
        }else{
            ListNode dummy = head;
            for(int i =0; i < index -1;i++){
                dummy = dummy.next;
            }
            dummy.next = dummy.next.next;
        }
        size--;
    }

    public void traverse(){
        if(head==null){
            System.out.println("Linked List does not exist.");
        }else{
            ListNode tempNode = head;
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
