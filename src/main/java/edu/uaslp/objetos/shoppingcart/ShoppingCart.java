package edu.uaslp.objetos.shoppingcart;

import edu.uaslp.objetos.shoppingcart.exceptions.ItemNotFoundException;

import java.util.LinkedList;

public class ShoppingCart implements List{
    private ShoppingItemCatalog catalog;
    private int itemsCount;
    private int distinctItemsCount;
    private Node head;
    private Node tail;
    private LinkedListIterator iterator;
    public ShoppingCart(ShoppingItemCatalog catalog){
        this.catalog = catalog;
        this.iterator = new LinkedListIterator(head);
        head = null;
        tail = null;
        itemsCount = 0;
        distinctItemsCount = 0;
    }

    @Override
    public void add(String code) throws ItemNotFoundException {
        ShoppingItem item = catalog.getItem(code);
        if(item == null){
            throw new ItemNotFoundException();
        }
        Node nuevo = new Node();
        nuevo.item = item;
        nuevo.previous = this.tail;
        if (this.head == null) {
            this.head = nuevo;
        } else {
            this.tail.next = nuevo;
        }
        this.tail = nuevo;
        itemsCount++;

    }

    @Override
    public int getTotalCostInCents() {
        int cost = 0;
        LinkedListIterator iterator = new LinkedListIterator(head);
        while(iterator.hasNext()){
            ShoppingItem item = iterator.next();
            cost += item.getUnitCostInCents();
        }
        return cost;
    }

    @Override
    public int getDistinctItemsCount() {
        return distinctItemsCount;
    }

    @Override
    public int getTotalItemsCOunt() {
        return itemsCount;
    }

    @Override
    public java.util.List<ShoppingItem> getItems() {
        LinkedListIterator iterator = new LinkedListIterator(head);
        java.util.List<ShoppingItem> itemsList = new LinkedList<>();
        while(iterator.hasNext()){
            ShoppingItem aux = iterator.next();
            itemsList.add(aux);
        }
        return itemsList;
    }
}
