package edu.uaslp.objetos.shoppingcart;

import edu.uaslp.objetos.shoppingcart.exceptions.ItemNotFoundException;

public interface List {
    void add(String code) throws ItemNotFoundException;

    int getTotalCostInCents();
    int getDistinctItemsCount();
    int getTotalItemsCOunt();
    java.util.List<ShoppingItem> getItems();

}
