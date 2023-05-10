package edu.uaslp.objetos.shoppingcart;

import edu.uaslp.objetos.shoppingcart.exceptions.ItemNotFoundException;
import java.util.ArrayList;
public class ShoppingCart{
    private ShoppingItemCatalog catalog;
    private int itemsCount;
    private int distinctItemsCount;
    private ArrayList<ShoppingItem> list = new ArrayList<>();
    public ShoppingCart(ShoppingItemCatalog catalog){
        this.catalog = catalog;
        itemsCount = 0;
        distinctItemsCount = 0;
    }

    public void add(String code) throws ItemNotFoundException {
        itemsCount=0;
        ShoppingItem item = catalog.getItem(code);
        if(item == null){
            String message = "Item with code "+code+" not found";
            throw new ItemNotFoundException(message);
        }
        list.add(itemsCount, item);
        itemsCount++;

    }

    public int getTotalCostInCents() {
        int cont=0, cost = 0;
        while(cont<itemsCount){
            ShoppingItem item = list.get(cont);
            cost += item.getUnitCostInCents();
            cont++;
        }
        return cost;
    }

    public int getDistinctItemsCount() {
        distinctItemsCount=0;
        for(int cont=0;cont<itemsCount;cont++){
            if(itemIsPresent(list.get(cont))){
                distinctItemsCount++;
            }
        }
        return distinctItemsCount;
    }

    public int getTotalItemsCount() {
        return itemsCount;
    }

    public java.util.List<ShoppingItem> getItems() {
        return list;
    }

    public boolean itemIsPresent(ShoppingItem item){
        for(int cont=0;cont<itemsCount;cont++){
            if(list.get(cont).getCode().equals(item.getCode())){return true;}
        }
        return false;
    }

    public java.util.List<ShoppingItem> getDistinctItems() {
        ArrayList<ShoppingItem> distinctArray = new ArrayList<>();
        for(int cont=0;cont<itemsCount;cont++){
            if(itemIsPresent(list.get(cont))){
                distinctArray.add(list.get(cont));
            }
        }
        return distinctArray;
    }
}

/// Cambios realizados: Uso de ArrayList de java.util, e implementación de getDistinctItemsCount() y getDistinctItems()
