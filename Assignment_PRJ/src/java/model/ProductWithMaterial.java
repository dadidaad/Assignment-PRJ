package model;

/**
 *
 * @author Admin
 */
public class ProductWithMaterial extends Product{
    String ProductWithMaterialID;
    String imgSrc;
    String ProductPrice;
    Material material;

    public String getProductWithMaterialID() {
        return ProductWithMaterialID;
    }

    public void setProductWithMaterialID(String ProductWithMaterialID) {
        this.ProductWithMaterialID = ProductWithMaterialID;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    public String getProductPrice() {
        if(ProductPrice.contains(".")){
            return ProductPrice.substring(0, ProductPrice.indexOf("."));
        }
        return ProductPrice;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    


    
    
}
