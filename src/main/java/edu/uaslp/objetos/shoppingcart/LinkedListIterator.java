package edu.uaslp.objetos.shoppingcart;

public class LinkedListIterator implements ListIterator{
    private Node currentNode;

    public LinkedListIterator() {
    }
    LinkedListIterator(Node head) {
        this.currentNode = head;
    }
    public boolean hasNext() {
        return this.currentNode != null;
    }

    public ShoppingItem next() {
        ShoppingItem item = this.currentNode.item;
        this.currentNode = this.currentNode.next;
        return item;
    }
}
