
public class LinkedListSolution{

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insertAtStart(9);
        list.insertAtIndex(0, 10);
        list.insertAtIndex(1, 11);
        list.insertAtIndex(7, 12);
       // list.insertAtIndex(9, 13);
        list.printLinkedList();
        System.out.println("After deleting the nodes.");
       // list.deleteAt(0);
        list.deleteAt(1);
        System.out.println("Actual list");
        list.printLinkedList();
        // list.reversePrint(list.head);
        list.reverseList();
        System.out.println("after reversing the list");
        list.printLinkedList();
        

    }
    
}

class Node{
    int data;
    Node next;
}

class LinkedList{
    Node head;

    public void insert(int data){
        Node node = new Node();
        node.data = data;

        if(head == null){
            head =node;
        }
        else{
            Node n = head;
            while(n.next!= null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void printLinkedList(){
        Node n = head;
        while(n!=null){
            System.out.println(n.data);
            n = n.next;
        }

    }

    public void reversePrint(Node head){
        if(head!=null)
        {
            //we are using recursion to go to the end of the list
            reversePrint(head.next);
            //when the function returns each time it executes all the statments under it .
            //Taking advantage of recursion to print the linked list in reverse order.
            System.out.println(head.data);
        }
        else
        {  //when we are at last element return
            return;
        }

    }
    public void insertAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;

    }
    public void insertAtIndex(int index,int data){
          
        Node node = new Node();
        node.data = data;
        if(index == 0)
        {
           node.next = head;
           head = node;
        }
        else{
            Node n = head;
            for(int i=0;i<index-1;i++){
                n= n.next;
            }
           Node b = n.next;
           n.next = node;
           n.next.next = b;

        }

    }

    public void deleteAt(int index){
        Node n = head;
        if(index == 0){
            Node b = n.next;
            n.next = null;
            head = b;
        }
        else{
            for(int i=0;i<index-1;i++){
                n=n.next;

            }
            Node b = n.next.next;
            n.next = b;
        }
    }
    public void reverseList(){
        //storing the head value in current
        Node current = head;
        //the previous varaible to track the previous value in list
        Node prev = null;
        //the next variable to track the next value in list 
        Node next = null;
        //break the loop if current value reaches the end of the list
        while(current!=null){
            //storing the next value of list
            next = current.next;
            //breaking the link and assigning the link to prev value
            current.next = prev;
            // moving the previous value towards the end of the list
            prev = current;
            //moving the current value towards the end of the list
            current = next;
        }
        //finally the last element is presenet the prev we will assign that to head
        head = prev;
    }
}