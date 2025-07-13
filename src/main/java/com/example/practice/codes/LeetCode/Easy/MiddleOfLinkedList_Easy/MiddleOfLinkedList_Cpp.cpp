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

/**
 * @timeComplexity : O(n)
 * @spaceComplexity : O(1)
 */
ListNode *findMiddleNodeOfLinkedList(ListNode *head)
{
    int n = 0;
    ListNode *temp = head;
    while (temp != NULL)
    {
        n++;
        temp = temp->next;
    }

    int middleNode = n / 2;
    temp = head;
    while (middleNode != 0)
    {
        middleNode--;
        temp = temp->next;
    }
    return temp;
}

void printLinkedList(ListNode *node){
    ListNode *temp = node;
    while(temp!=NULL){
        cout << temp -> value << "-> ";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

int main(){
    ListNode *head = scanLinkedListAndReturnHead();

    ListNode *middleNode = findMiddleNodeOfLinkedList(head);
    printLinkedList(middleNode);
    return 0;
}