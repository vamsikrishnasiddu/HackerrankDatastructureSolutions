
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
    //This will insert the node at the end of the list
    public void insert(int data){
        //create a empty node
        Node node = new Node();
        //assign the data to the node
        node.data = data;
       //if there are no previous nodes then assign
       //the value to the head
       //its the first node
        if(head == null){
            head =node;
        }
        //otherwise create a node traverse to the end
        //of the list and insert the node there.
        else{
            Node current = head;
            //condition to check the last node
            while(current.next!= null){
                //traversing the list
                current = current.next;
            }
            //attaching the new node to the end of the list
            current.next = node;
        }
    }

    public void printLinkedList(){
        //traverse the list and print the data of each node
        Node current = head;
        //break when the list reaches the last node
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
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
        //change the head to the newly created node
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;

    }
    public void insertAtIndex(int index,int data){
          
        Node node = new Node();
        node.data = data;
        //if index is equal to 0 change the head node to new node
        if(index == 0)
        {
           node.next = head;
           head = node;
        }
        //traverse the list upto the index attach it there
        else{
            Node current = head;
            //just stop at the one element before index
            for(int i=0;i<index-1;i++){
                current= current.next;
            }
            //change the links to the elements
           Node next = current.next;
           current.next = node;
           current.next.next = next;

        }

    }

    public void deleteAt(int index){
        Node current = head;
        Node next =null;
        if(index == 0){
            //store the next value of current element in 
            //next variable and change the link to point to null
            //point the head value to next
             next = current.next;
            current.next = null;
            head = next;
        }
        else{
            //stop just at the one element before the index
            for(int i=0;i<index-1;i++){
                current=current.next;

            }
            //save the element in the next varibale for the furthur traversal.
            next = current.next.next;
            current.next = next;
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