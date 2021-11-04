package model;

/**
 *
 * @author Admin
 */
public class ProductWithMaterial extends Product{
    String ProductWithMaterialID;
    String ProductPrice;
    Material material;
    Object productImg;
    String base64Image;
    public String getProductWithMaterialID() {
        return ProductWithMaterialID;
    }

    public void setProductWithMaterialID(String ProductWithMaterialID) {
        this.ProductWithMaterialID = ProductWithMaterialID;
    }

    public Object getProductImg() {
        return productImg;
    }

    public void setProductImg(Object productImg) {
        this.productImg = productImg;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
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
