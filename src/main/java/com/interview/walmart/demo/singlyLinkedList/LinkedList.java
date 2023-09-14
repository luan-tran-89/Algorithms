package com.interview.walmart.demo.singlyLinkedList;

/**
 * @author gasieugru
 */
public class LinkedList {

    Node head = null;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public void insertAt(int data, int index) {
        Node newNode = new Node(data);

        if (index == 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currentNode = head;
        Node prevNode = null;
        int count = 0;

        while(currentNode != null) {
            if (count == index) {
                prevNode.next = newNode;
                newNode.next = currentNode;
                break;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
                count++;
            }
        }

        // insert last
        if (count <= index) {
            prevNode.next = newNode;
        }
    }

    public void remove(int data) {
        Node currentNode = head;
        Node prevNode = null;

        if (currentNode != null && currentNode.data == data) {
            head = currentNode.next;
            return;
        }

        while(currentNode != null && currentNode.data != data) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            prevNode.next = currentNode.next;
        }
    }

    public void removeAt(int index) {
        Node currentNode = head;
        Node prevNode = null;

        // remove head
        if (index == 0 && currentNode != null) {
            head = currentNode.next;
            return;
        }

        int count = 0;
        while (currentNode != null) {
            if (count == index) {
                prevNode.next = currentNode.next;
                break;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
                count++;
            }
        }
    }

    public void printList() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder("LinkedList = [");
        while(currentNode != null) {
            sb.append(currentNode.data);
            currentNode = currentNode.next;
            sb.append(currentNode == null ? "" : " ");
        }
        sb.append("]");

        System.out.println(sb.toString().trim());
    }

    class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.printList();

        linkedList.remove(3);
        linkedList.printList();

        linkedList.removeAt(2);
        linkedList.printList();

        linkedList.insertAt(6, 3);
        linkedList.printList();

        linkedList.insertAt(3, 2);
        linkedList.printList();
    }
}
