package com.example.practice.codes.LeetCode.Easy.MiddleOfLinkedList_Easy;

import com.example.practice.codes.Utilities.ListNode;

import java.util.Scanner;

import static com.example.practice.codes.Utilities.SinglyLinkedListUtilities_Java.printLinkedList;
import static com.example.practice.codes.Utilities.SinglyLinkedListUtilities_Java.scanLinkedListAndReturnHead;

public class MiddleOfLinkedList_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = scanLinkedListAndReturnHead(false, sc);

        ListNode middleNode = findMiddleNodeOfLinkedList(head);
        printLinkedList(middleNode);
        sc.close();
    }

    private static ListNode findMiddleNodeOfLinkedList(ListNode head) {
        int n=0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }

        int middleNode = n/2;
        temp = head;
        while(middleNode != 0){
            middleNode--;
            temp = temp.next;
        }
        return temp;
    }
}
