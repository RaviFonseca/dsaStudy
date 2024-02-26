package org.example;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public LinkedList (int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append( int value){
        Node newNode = new Node(value);

        if (length == 0){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast(){
        Node temp1 = head;
        Node temp2 = head.next;
        if (length == 0 ){
            return null;
        }
        else if( length == 1){
            temp1 = head;
            head = null;
            tail = null;
            length--;
            return temp1;
        }
        else{
            while (temp2.next != null){
                temp1 = temp2;
                temp2 = temp2.next;
            }
            tail = temp1;
            tail.next = null;
            length--;

        }
        return temp2;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        Node temp;
        if (length == 0) {
            return null;
        }
        temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

//    public Node removeFirst(){
//        if (length == 0) return null;
//        Node temp = head;
//        if (length ==1){
//            head = null;
//            tail = null;
//        }else {
//            head = head.next;
//        }
//        length--;
//        return temp;
//    }

    public Node get(int index){
        if((index < 0) || (index>length)){
            return null;
        }
        Node temp = head;
        int i = 0;
        while(i !=index){
            temp=temp.next;
            i++;
        }
        return temp;
    }

    public boolean set(int index, int value){
       Node temp = get(index);
       if(temp != null){
           temp.value = value;
           return true;
       }
       return false;
    }
    public boolean insert(int index, int value){
        if(index<0 || index>length) return  false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index ==length-1){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if ((index<0)||(index>=length)) return null;

        if (index ==0)
            removeFirst();

        if( index == length-1)
            removeLast();

        Node temp1 = get(index-1);
        Node temp2 = temp1.next;
        temp1.next = temp2.next;
        temp2.next = null;
        length--;
        return temp2;
    }

     public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i =0;i<=length;i++){
            after = temp.next;
            temp.next =before;
            before = temp;
            temp = after;
        }
    }


    public void getHead() {
        System.out.println("Head: "+head.value);
    }

    public void getTail() {
        System.out.println("Tail: "+tail.value);
    }

    public void getLength() {
        System.out.println("Length: "+length);
    }

    /************************* INTERVIEW EXERCISES ********************************/


    public Node findMiddleNode(){
        Node temp1 = head;
        Node temp2 = head;

//        while (temp2!=null){
//            temp1 = temp1.next;
//            temp2 = temp2.next.next;
//        }

        do{
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }while (temp2!=null);

        return temp1;
    }

    public boolean hasLoop(){
//        if (length == 0){
//            return false;
//        }
//        if (length == 1){
//            return false;
//        }
        // Initialize both pointers to the head of the linked list
        Node slow = head;
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast){
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }

    public Node findKthFromEnd(int k){
//        Node temp1 = head;
//        if (head == null) return null;
//        int i =1;
//        while (temp1.next != null){
//            temp1 = temp1.next;
//            i++;
//        }
//        int rest = i - k;
//
//        if(rest<0)return null;
//        Node temp2 = head;
//        int j =0;
//        while (j!=rest){
//            j++;
//            temp2 = temp2.next;
//        }
//        return temp2;
        Node slow = head;
        Node fast = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }
}
