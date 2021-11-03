package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class ItemHistoryBuy {
    private String username;
    private String productWithMaterialID;
    private Timestamp DateBuy;
    private int quantity;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductWithMaterialID() {
        return productWithMaterialID;
    }

    public void setProductWithMaterialID(String productWithMaterialID) {
        this.productWithMaterialID = productWithMaterialID;
    }

    public Timestamp getDateBuy() {
        return DateBuy;
    }

    public void setDateBuy(Timestamp DateBuy) {
        this.DateBuy = DateBuy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
