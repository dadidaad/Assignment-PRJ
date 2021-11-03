package model;

/**
 *
 * @author Admin
 */
public class Category {
    private String CategoryID;
    private String CategoryName;

    public Category() {
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
}
