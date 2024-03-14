import SinglyLinkedList.Node;
import SinglyLinkedList.SinglyLinkedList;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.create(1);
        sll.insertNode(2,2);
        sll.insertNode(3,3);
        sll.insertNode(4,3);
        sll.insertNode(5,2);
        sll.insertNode(6,1);
//        sll.insertNode(7,7);

        sll.traverse();
        isPalindrome(sll.head);
        sll.traverse();
    }
    // ===============================================================================
    // Reverse a Linked List
    public static Node reverse(Node head){
        Node prev = null;
        while (head != null){
            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }
    public static Node reverseCopy(Node head){
        Node prev = null;
        while(head != null){
            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    // ===============================================================================
    //reverseFromMiddle
    public static Node reverseFromMiddle(Node head){
        Node slow = head;
        Node fast = head.next;
        int n = 0;
        while(fast != null && fast.next != null){
            n++;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node dummy = slow.next;
        Node prev = slow;

        while(dummy != null){
            Node nextNode = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = nextNode;
        }

        return head;
    }


    // ===============================================================================
    // 19. Remove Nth Node from end of the list
    public static Node removeNthFromEnd(Node head, int n){
        Node slow = head;
        Node fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while( fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    // ===============================================================================
    // 24. Swap Nodes in Pairs
    public static Node swapPairs(Node head){
        if(head == null || head.next == null) return head;
        Node dummy = head.next;
        Node prev = null;

        while(head != null && head.next != null){
            if(prev != null){
                prev.next = head.next;
            }
            Node nextNode = head.next.next;
            head.next.next = head;
            prev = head;
            head.next = nextNode;
            head = nextNode;
        }

        return dummy;
    }
    public static Node swapPairsCopy(Node head){
        if(head == null || head.next == null)  return head;
        Node dummy = head.next;
        Node prev = null;

        while(head!=null && head.next != null){

            if(prev!=null){
                prev.next = head.next;
            }

            Node nextNode = head.next.next;
            head.next.next = head;
            prev = head;
            head.next = nextNode;
            head =nextNode;
        }

        return dummy;
    }

    // ===============================================================================
    // 82. Remove Duplicates from Sorted List II
    public static Node deleteDuplicates(Node head){
        Node sentinel = new Node(0, head);
        Node prev = sentinel;

        while(head != null){
            if (head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }else{
                prev = prev.next;
            }
            head = head.next;
        }

//        head = head.next;

        return sentinel.next;
    }

    // ===============================================================================
    // 92. Reverse Linked List II
    public static Node reverseBetween(Node head, int left, int right) {
        if(head == null){
            return null;
        }

        Node curr = head;
        Node prev = null;
        while(left>1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        Node prevCopy = prev;
        Node tail = curr;
        Node third = null;
        while(right > 0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            right--;
        }

        if(prevCopy!=null){
            prevCopy.next = prev;
        }else{
            head = prev;
        }
        tail.next = curr;

        return head;
    }

    // ===============================================================================
    // 234. Palindrome Linked List
    public static boolean isPalindrome(Node head){
        Node dummy = head;
        Node prev = null;
        int size = 0;
        while(dummy != null){
            Node nextNode = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = nextNode;
            size++;
        }
        System.out.println(size);
        System.out.println(head.next.val);
//        for(int i = 0; i < size/2;i++){
//            if (head.val == prev.val){
//                head = head.next;
//                prev = prev.next;
//            }else{
//                return false;
//            }
//        }

        return true;
    }

    // ===============================================================================

    // 1290. Convert Binary Number in a Linked List to Integer
    public static int getDecimalValue(Node head){
        int num = head.val;

        while (head.next != null){
            num = num * 2 + head.next.val;
            head = head.next;
        }

        return num;
    }

    // ===============================================================================
    // 1721. Swapping Nodes in Linked List
    public static Node swapNodes(Node head,int k){
        Node slow = null;
        Node fast = null;
        Node curr = head;
        int length = 0;
        while(curr != null){
            length++;
            if (fast != null) {
                fast = fast.next;
            }
            if(length == k){
                slow = curr;
                fast = head;
            }
            curr = curr.next;
        }

        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;

        return head;
    }

    // 2095. Delete the Middle Node of Linked List
    public static Node deleteMiddle(Node head){
        if(head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev.next = slow.next;

        return head;
    }

    // 2130. Maximum Twin Sum of a Linked List
    public static int pairSum(Node head) {
        Node slow = head;
        Node fast = head.next;
        int n = 0;
        while(fast != null && fast.next != null){
            n++;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node dummy = slow.next;
        Node prev = slow;

        while(dummy != null){
            Node nextNode = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = nextNode;
        }

        int ans = 0;
        for(int i = 0; i <= n; i++){
            int sum = head.val + fast.val;
            head = head.next;
            fast = fast.next;
            ans = Math.max(ans,sum);
        }

//        System.out.println("Slow: " + head.val);
//        System.out.println("Fast: " + fast.val);
        return ans;
    }
}
