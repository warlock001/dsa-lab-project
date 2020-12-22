package DoublyLinkedListDS;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    Scanner sc = new Scanner(System.in);
    private Node first; // Holding the reference of First Node
    public Node last; // Holding the reference of Last Node
    private static DoublyLinkedList dl=null;



    public DoublyLinkedList(){
        // At first when we create an object both of the pointers will be null
        this.first = null;
        this.last = null;
    }
    public static DoublyLinkedList getInstance() {
        if (dl == null)
            dl = new DoublyLinkedList();
        return dl;
    }


        // Checking for empty Linked List
    public boolean isEmpty(){
        return (first == null);
    }

    // This function will Insert Node at First Position
    public void insertAtFirst(pet pet){
        Node newNode = new Node();
        newNode.data = pet;
        if(isEmpty()){
            // if linked list is empty then and only then last reference will be changed
            last = newNode;
        }else{
            // we are changing the previous pointer of old first to point to new first
            first.previous = newNode;
        }
        // New first node next pointer will now points to the old first node
        newNode.next = first;
        // Changing the reference of first pointer to point to new first node
        first = newNode;
    }

    // This function will Insert Node at Last Position
    public void insertAtLast(pet pet){
        Node newNode = new Node();
        newNode.data = pet;
        if(isEmpty()){
            // if linked list is empty then and only then first reference will be changed
            first = newNode;
        }
        else{
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }

    // This function will delete Node From First Position
    public Node deleteFromFirst(){
        Node temp = first;
        if(isEmpty())
            throw new NoSuchElementException("Linked List is already Empty!");
        else if(first.next == null)
            last = null;
        else
            // We are changing the second node previous pointer to be equal to null
            first.next.previous = null;
        // First pointer will be pointer next node available after first
        first = first.next;
        return temp;
    }

    // This function will delete Node From Last Position
    public Node deleteFromLast(){
        Node temp = last;
        if(isEmpty())
            throw  new NoSuchElementException("Linked List is already Empty!");
        else if(first.next == null)
            first = null;
        else
            last.previous.next = null; // Second Last next pointer to now point to null
        last = last.previous;
        return temp;
    }

    // This function will insert After a given Node by the help of key
    public boolean insertAfter(int key,pet pet){
        if(isEmpty())
            throw  new NoSuchElementException("Linked List is already Empty!");
        Node currentNode = first; // Start from the first node for searching the key
        while (currentNode.data.id != key){
            currentNode = currentNode.next;
            if(currentNode == null)
                return false;
        }
        Node newNode = new Node();
        newNode.data = pet;
        if(currentNode == last){
            currentNode.next = null;
            last = newNode;
        }else{
            newNode.next = currentNode.next;
            currentNode.next.previous = newNode;
        }
        newNode.previous = currentNode;
        currentNode.next = newNode;
        return true;
    }
    public int printPetId(int key){
        Node currentNode = first; // Start from the first node for searching the key
        if(currentNode.data == null){
            System.out.println("empty");
        }
        while (currentNode.data.id != key){
            currentNode = currentNode.next;

        }
         currentNode.displayNode();
        return 0;
    }

    public Node deleteNodeAtKey(int key){

        Node current = first;
        while (current.data.id != key){
            current = current.next;
            if(isEmpty())
                throw  new NoSuchElementException("Linked List is already Empty!");
            if(current == null)
                return null;
        }

        if(current == first){
            first = first.next;
        }else{
            current.previous.next = current.next;
        }

        if(current == last){
            last = last.previous;
        }else{
            current.next.previous = current.previous;
        }
        while (current.next!=null){
            current=current.next;
       current.data.id--;



        }
        return current;
    }

    public void printForward(){
        //System.out.println("Printing in Forward Direction (First Node ---> Last Node)");
        Node currentNode = first;
        while (currentNode != null){
            currentNode.displayNode();
            currentNode = currentNode.next;
        }
        System.out.println();
        /*if(!isEmpty()){
            System.out.println("First Ptr ===> "+first.data);
            System.out.println("Last Ptr ===> "+last.data);
        }*/
    }

    public void printBackward(){
        System.out.println("Printing in Backward Direction (Last Node ---> First Node)");
        Node currentNode = last;
        while (currentNode != null){
            currentNode.displayNode();
            currentNode = currentNode.previous;
        }
        System.out.println();
        /*if(!isEmpty()){
            System.out.println("First Ptr ===> "+first.data);
            System.out.println("Last Ptr ===> "+last.data);
        }*/
    }




}
