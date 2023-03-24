/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

/**
 *
 * @author aleno
 */
public interface ICustomer {
    public void buyProduct();
    public void viewCart();
    public void payForProduct(boolean check);
}
