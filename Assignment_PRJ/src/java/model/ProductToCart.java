package model;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class ProductToCart {
    private ProductWithMaterial productWithMaterial;
    private int quantity;
    public ProductToCart() {
    }

    public ProductWithMaterial getProductWithMaterial() {
        return productWithMaterial;
    }

    public void setProductWithMaterial(ProductWithMaterial productWithMaterial) {
        this.productWithMaterial = productWithMaterial;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSubTotal() {
        BigInteger productPrice = new BigInteger(productWithMaterial.getProductPrice());
        return productPrice.multiply(BigInteger.valueOf(quantity)).toString();
    }

    
}
