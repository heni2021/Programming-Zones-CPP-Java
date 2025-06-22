package com.example.practice.codes.Utilities;

import java.util.Scanner;

public class SinglyLinkedListUtilities_Java {

    public static ListNode scanNewNode(){
        int val;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter val in node - ");
        val = sc.nextInt();
        return new ListNode(val , null);
    }

    public static ListNode scanLinkedListAndReturnHead(boolean stop, Scanner sc) {
        ListNode head;
        head = scanNewNode();
        while(!stop){
            System.out.print("Continue ? ");
            stop = sc.nextBoolean();
            if(!stop) {
                ListNode newNode = scanNewNode();
                ListNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode temp = head;
        while(temp!= null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static ListNode getNewNodeWithVal(int value){
        return new ListNode(value , null);
    }

    public static ListNode reverseLinkedList(ListNode head){
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode;
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }


        return previousNode;
    }
}
