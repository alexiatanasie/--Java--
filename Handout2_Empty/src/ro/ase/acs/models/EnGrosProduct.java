//HOMEWORK 2 TANASIE ALEXIA STEFANIA
package ro.ase.acs.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

 //6
public class EnGrosProduct extends Product implements Cloneable {
   
	private float discount; //between 0 and 1
    
    private static Map<String, EnGrosProduct> stock = new HashMap<>();

    public EnGrosProduct(String name, float price, int quantity) {
        
    	
    	super(name, price, quantity);
        if (quantity < 10) {
            this.discount = 0f;
        } else if (quantity < 20) {
            this.discount = 0.05f;
        } 
        else {
            this.discount = 0.10f;
        }
    }
    
 //7
    @Override
    public float getDiscount() {
        return price*discount;
    }
//8 
    //getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public EnGrosProduct clone() {
        return new EnGrosProduct(new String(name), price, quantity);
    }
    
//9
    @Override
    public String toString() {
    	//calc total price before applying discount
        float valBeforeDiscount = price * quantity;
        //calc total price after applying discount
        float totalAfterDiscount = valBeforeDiscount - (getDiscount() * quantity);
       //convert discount to a percentage for display
        int discountPercent = (int)(discount * 100);
        //output
        return String.format(java.util.Locale.US,
                "> %s %.1f %d %d%% %.1f %.3f",
                name, price, quantity, discountPercent,
                valBeforeDiscount, totalAfterDiscount);
    }
//10
    //add a static map for managing stock by unique key(name +price) 
    public static void addProduct(EnGrosProduct product) {
        String p = product.name + "|" + product.price;
 //check if the product laready exists in the stock
        if (stock.containsKey(p)) {
            EnGrosProduct existing = stock.get(p);
            //combine the quantities
            int Q = existing.quantity + product.quantity;
            EnGrosProduct merged = new EnGrosProduct(product.name, product.price, Q);
            stock.put(p, merged);
        } else {
            stock.put(p, product.clone());
        }
    }

    public static String printStock() {
        StringBuilder stringBuilder = new StringBuilder();
        float tot = 0f;
        
        ///loop all products in stock and build the output string
        
        for (EnGrosProduct product : stock.values()) {
        	stringBuilder.append(product.toString()).append("\n");
           //sum total value before discount
        	tot = tot+product.price * product.quantity;
        }

        stringBuilder.append(String.format(java.util.Locale.US,
                "Total value of the stock without discount: %.1f", tot));

        return stringBuilder.toString();
    }
}
