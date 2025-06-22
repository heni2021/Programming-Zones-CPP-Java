// https://leetcode.com/problems/add-two-numbers/description/
package com.example.practice.codes.LeetCode.AddTwoNumbersInTwoSinglyLinkedList_Medium;

import com.example.practice.codes.Utilities.ListNode;

import java.util.Scanner;

import static com.example.practice.codes.Utilities.SinglyLinkedListUtilities_Java.*;

public class AddTwoNumbersInTwoSinglyLinkedList_Java {
    public static void main(String[] args) {
        ListNode l1, l2;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        l1 = scanLinkedListAndReturnHead(stop, sc);
        printLinkedList(l1);
        l2 = scanLinkedListAndReturnHead(stop, sc);
        printLinkedList(l2);
        ListNode sum = addTwoNumbersInLinkedList(l1, l2);
        printLinkedList(sum);
        sc.close();
    }

    /**
     * Approach
     * We have place two pointers on the head of both linked lists.
     * Then we will parse it through the linked list. Then create a new node with value sum/10 having carry sum%10.
     * While parsing, it if we reach to the end of the either of the linked list then rest of the linked list will be placed as it is.
     * Edge case: If at last still carry is remaining then we will place carry as the value in new node.
     * @timeComplexity : O(n+m) - n : Number of nodes in first linked list and m : Number of nodes in second linked list.
     * @spaceComplexity : O(1)
     * @param l1 - Head of first linked list.
     * @param l2 - Head of second linked list
     * @return head of the new linked list
     */
    private static ListNode addTwoNumbersInLinkedList(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode currentNode1 = l1, currentNode2 = l2;
        ListNode result = l1;
        while(currentNode1 != null && currentNode2 != null){
            int sum = currentNode1.value + currentNode2.value + carry;
            carry = sum / 10;
            ListNode newNode = getNewNodeWithVal(sum%10);
            if(currentNode1 == l1 && currentNode2 == l2){
                result = newNode;
            }
            else{
                ListNode temp = result;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        while(currentNode1 != null){
            int sum = currentNode1.value + carry;
            carry = sum / 10;
            ListNode newNode = getNewNodeWithVal(sum%10);
            if(currentNode1 == l1){
                result = newNode;
            }
            else{
                ListNode temp = result;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            currentNode1 = currentNode1.next;
        }

        while(currentNode2 != null){
            int sum = currentNode2.value + carry;
            carry = sum / 10;
            ListNode newNode = getNewNodeWithVal(sum%10);
            if(currentNode2 == l1){
                result = newNode;
            }
            else{
                ListNode temp = result;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            currentNode2 = currentNode2.next;
        }
        if(carry != 0){
            ListNode newNode = getNewNodeWithVal(carry);
            ListNode temp = result;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return result;
    }
}
