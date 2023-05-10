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
        distinctItemsCount=0;
        ArrayList<ShoppingItem> distinctArray = (ArrayList<ShoppingItem>) getDistinctItems();
        distinctItemsCount = distinctArray.size();
        return distinctItemsCount;
    }

    public int getTotalItemsCount() {
        return itemsCount;
    }

    public java.util.List<ShoppingItem> getItems() {
        return list;
    }

    public boolean itemIsRepeated(ShoppingItem item, ArrayList<ShoppingItem> array){
        int contRepeat=0;
        for(int cont=0;cont<array.size()-1;cont++){
            if(array.get(cont).getCode().equals(item.getCode())){contRepeat++;}
        }
        if(contRepeat>=1){return true;}
        else{return false;}
    }

    public java.util.List<ShoppingItem> getDistinctItems() {
        ArrayList<ShoppingItem> distinctArray = new ArrayList<>();
        distinctArray.addAll(list);
        for(int cont=0;cont<list.size();cont++){
            if(itemIsRepeated(list.get(cont), distinctArray)){
                distinctArray.remove(cont);
            }
        }
        return distinctArray;
    }

    public void printArray(ArrayList<ShoppingItem> array){
        for(int cont=0;cont<array.size();cont++){
            System.out.print(array.get(cont).getCode()+"-->");
        }
    }
}

/// Cambios realizados: Uso de ArrayList de java.util, e implementación de getDistinctItemsCount() y getDistinctItems()
