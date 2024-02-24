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
}
