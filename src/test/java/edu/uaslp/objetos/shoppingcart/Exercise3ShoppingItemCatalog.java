package edu.uaslp.objetos.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise3ShoppingItemCatalog {
    @Test
    public void givenAValidCode_whenGetItem_thenShoppingItemIsReturned(){
        //Initialization
        ShoppingItemCatalog shoppingItemCatalog = new ShoppingItemCatalog();
        ShoppingCart shoppingCart = new ShoppingCart(shoppingItemCatalog);
        String code = "ABC";
        //Execution
        shoppingCart.add(code);
        ShoppingItem item = shoppingItemCatalog.getItem("ABC");
        //Validation
        Assertions.assertEquals(code,item.getCode());
        Assertions.assertNotNull(item);
    }

    @Test
    public void givenANotValidCode_whenGetItem_thenNullIsReturned(){

    }
}
