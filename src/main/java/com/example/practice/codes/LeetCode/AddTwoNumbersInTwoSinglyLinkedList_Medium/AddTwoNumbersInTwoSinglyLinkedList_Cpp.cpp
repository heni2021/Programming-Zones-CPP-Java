#include <iostream>
using namespace std;

struct ListNode
{
    int value;
    ListNode *next;
};

ListNode *scanNewNode()
{
    int val;
    cout << "Enter val in node - ";
    cin >> val;

    ListNode *newNode = new ListNode;
    newNode->value = val;
    newNode->next = NULL;

    return newNode;
}

ListNode *scanLinkedListAndReturnHead()
{
    char choice;
    cout << "Want to create a node? (y/n): ";
    cin >> choice;

    if (choice != 'y' && choice != 'Y')
        return NULL;

    ListNode *head = scanNewNode();
    ListNode *tail = head;

    while (true)
    {
        cout << "Want to add more nodes? (y/n): ";
        cin >> choice;
        if (choice != 'y' && choice != 'Y')
            break;

        ListNode *newNode = scanNewNode();
        tail->next = newNode;
        tail = newNode;
    }

    return head;
}

void printLinkedList(ListNode *head)
{
    ListNode *temp = head;
    while (temp != NULL)
    {
        cout << temp->value << " -> " ;
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

ListNode *getNewNodeWithVal(int value)
{
    ListNode *newNode = new ListNode;
    newNode -> next = NULL;
    newNode -> value = value;
    return newNode;
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
ListNode *addTwoNumbersInLinkedList(ListNode *l1, ListNode *l2)
{
    int carry = 0;

    ListNode *currentNode1 = l1, *currentNode2 = l2;
    ListNode *result = l1;
    while (currentNode1 != NULL && currentNode2 != NULL)
    {
        int sum = currentNode1->value + currentNode2->value + carry;
        carry = sum / 10;
        ListNode *newNode = getNewNodeWithVal(sum % 10);
        if (currentNode1 == l1 && currentNode2 == l2)
        {
            result = newNode;
        }
        else
        {
            ListNode *temp = result;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }

        currentNode1 = currentNode1->next;
        currentNode2 = currentNode2->next;
    }

    while (currentNode1 != NULL)
    {
        int sum = currentNode1->value + carry;
        carry = sum / 10;
        ListNode *newNode = getNewNodeWithVal(sum % 10);
        if (currentNode1 == l1)
        {
            result = newNode;
        }
        else
        {
            ListNode *temp = result;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }
        currentNode1 = currentNode1->next;
    }

    while (currentNode2 != NULL)
    {
        int sum = currentNode2->value + carry;
        carry = sum / 10;
        ListNode *newNode = getNewNodeWithVal(sum % 10);
        if (currentNode2 == l1)
        {
            result = newNode;
        }
        else
        {
            ListNode *temp = result;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }
        currentNode2 = currentNode2->next;
    }
    if (carry != 0)
    {
        ListNode *newNode = getNewNodeWithVal(carry);
        ListNode *temp = result;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = newNode;
    }
    return result;
}

int main(){
    ListNode *l1, *l2;
    l1 = scanLinkedListAndReturnHead();
    printLinkedList(l1);
    l2 = scanLinkedListAndReturnHead();
    printLinkedList(l2);
    ListNode *sum = addTwoNumbersInLinkedList(l1, l2);
    printLinkedList(sum);
    return 0;
}