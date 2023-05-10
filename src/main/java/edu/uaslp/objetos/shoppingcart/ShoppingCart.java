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
        int contItem, limit = 1;
        ArrayList<ShoppingItem> auxArray = new ArrayList<>();
        ShoppingItem auxItem = list.get(0);
        auxArray.add(auxItem);
        for(contItem = 0; contItem<itemsCount; contItem++) {
            for (int contFor=0;contFor<limit;contFor++) {
                System.out.println(auxArray.get(contFor).getCode()+"=="+auxItem.getCode());
                if ((auxArray.get(contFor).getCode().equals(auxItem.getCode()))==false) {
                    System.out.println(auxArray.get(contFor).getCode()+"!="+auxItem.getCode());
                    auxArray.add(auxItem);
                    limit++;
                    distinctItemsCount++;
                }
            }
            auxItem = list.get(contItem);
        }
        return distinctItemsCount;
    }

    public int getTotalItemsCount() {
        return itemsCount;
    }

    public java.util.List<ShoppingItem> getItems() {
        return list;
    }

    public java.util.List<ShoppingItem> getDistinctItems() {
        int limit = 1;
        ArrayList<ShoppingItem> auxArray = new ArrayList<>();
        ShoppingItem auxItem = list.get(0);
        auxArray.add(auxItem);
        for(int contItem = 0; contItem<itemsCount; contItem++) {
            for (int contFor=0;contFor<limit;contFor++) {
                if ((auxArray.get(contFor).getCode().equals(auxItem.getCode()))==false) {
                    auxArray.add(auxItem);
                    limit++;
                }
            }
            auxItem = list.get(contItem);
        }
        return auxArray;
    }
}

/// Cambios realizados: Uso de ArrayList de java.util, e implementación de getDistinctItemsCount() y getDistinctItems()
