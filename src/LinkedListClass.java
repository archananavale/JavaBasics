


import java.util.LinkedList;
import java.util.SortedMap;

class LinkedListEx{
    Node head; //head of list
    /*
    the inner class made static so it can access by main() methode
     */
    static  class Node{
        int data;
        Node next;
        Node(int data1){
            data=data1;
            next=null;
        }
    }

    /*
    Methode : indert new node
     */
    public  static LinkedListEx insert(LinkedListEx list,int data){
        Node newNode= new Node(data);
        newNode.next=null;
        if(list.head==null){//list is empty
            list.head=newNode;
        }else {
            //go to last node
            Node last=list.head;
            while (last.next!= null){
                last=last.next;
            }
            //insert the new node at end
            last.next=newNode;
        }
        return list;// return list by head
    }
    //Print linked list
    public static void printLinkedList(LinkedListEx list){
        Node currentNode= list.head;
        System.out.println("Linked list : ");
        while (currentNode != null){
            System.out.println(currentNode.data + " ");
            currentNode=currentNode.next;
        }
    }

    //Delete node
    public static LinkedListEx deleteNodeFromList(LinkedListEx list, int data){

        Node currNode=list.head, prevNode=null;

        if(currNode !=null && currNode.data== data){
            list.head=currNode.next;
            System.out.println(data + " deleted");
            return list;
        }
        //Finding key in list

            while (currNode != null && currNode.data!= data){
                //go to next next node
                prevNode=currNode;
                currNode=currNode.next;
            }

            if(currNode!=null) {
                //found node
                prevNode.next=currNode.next;
                System.out.println(data + " found and deleted");
            }else if(currNode==null)
                System.out.println(data + " Not found");

    return (list);

    }
    public static LinkedListEx
    deleteAtPosition(LinkedListEx list, int index)
    {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be
        // deleted

        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(
                    index + " position element deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the
        // size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required
                // position Unlink currNode from linked list
                prev.next = currNode.next;

                // Display the message
                System.out.println(
                        index + " position element deleted");
                break;
            }
            else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be
        // null
        //
        // CASE 3: The index is greater than the size of the
        // LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(
                    index + " position element not found");
        }

        // return the List
        return list;
    }
}
public class LinkedListClass {
    public static void main(String[] args) {
        LinkedListEx list= new LinkedListEx();
        list=LinkedListEx.insert(list,1);
        list=LinkedListEx.insert(list,12);
        list=LinkedListEx.insert(list,123);
        list=LinkedListEx.insert(list,1222);
        list=LinkedListEx.insert(list,1987);
        list=LinkedListEx.insert(list,192);
        list=LinkedListEx.insert(list,12993);
        list=LinkedListEx.insert(list,129922);
        list=LinkedListEx.insert(list,198997);

        LinkedListEx.printLinkedList(list);
        System.out.println("Delete funtion ");
        LinkedListEx.deleteNodeFromList(list,1);
        LinkedListEx.printLinkedList(list);
        LinkedListEx.deleteAtPosition(list,3);
        LinkedListEx.printLinkedList(list);


    }
}
 /*   public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);*//*
    }*/