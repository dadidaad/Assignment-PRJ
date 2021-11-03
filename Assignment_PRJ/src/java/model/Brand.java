package model;

/**
 *
 * @author Admin
 */
public class Brand {
    String BrandID;
    String BrandName;
    Category CategoryID;

    public Brand() {
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public Category getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Category CategoryID) {
        this.CategoryID = CategoryID;
    }

    
    
}
