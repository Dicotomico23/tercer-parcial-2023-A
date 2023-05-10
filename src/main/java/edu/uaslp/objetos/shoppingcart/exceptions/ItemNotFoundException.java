package edu.uaslp.objetos.shoppingcart.exceptions;

public class ItemNotFoundException extends ShoppingCartException{
    private String message;
    public ItemNotFoundException(String message){
        super(message);
    }
}
