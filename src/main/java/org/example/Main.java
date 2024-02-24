package org.example;

public class Main {
    public static void main( String[] args) {

        LinkedList myLinkedList = new LinkedList(11);

        myLinkedList.append(3);
        myLinkedList.append(23);
        myLinkedList.append(7);
        myLinkedList.append(4);
        myLinkedList.append(8);
        System.out.println("before inserting");
        myLinkedList.printList();
//        System.out.println("get");
//        System.out.println(myLinkedList.get(2).value);

//        myLinkedList.insert(1,5);
//        System.out.println("\nafter inserting\n");
//        myLinkedList.printList();
//        System.out.println("\nafter removing first\n");
//        myLinkedList.removeFirst();
//        myLinkedList.printList();


        System.out.println(myLinkedList.findMiddleNode().value);




//        newList.getHead();
//        newList.getTail();
//        newList.getLength();
//        newList.printList();

    }

}