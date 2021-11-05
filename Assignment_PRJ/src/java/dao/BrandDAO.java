package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Brand;
import model.Category;
import model.Material;

/**
 *
 * @author Admin
 */
public class BrandDAO extends BaseDAO<Object> {

    public ArrayList<Brand> getAllBrand() {
        ArrayList<Brand> listBrandByCategory = new ArrayList<>();
        try {
            String sql = "SELECT dbo.Brand.*, dbo.Category.CategoryName\n"
                    + "FROM dbo.Category INNER JOIN dbo.Brand ON dbo.Category.CategoryID = dbo.Brand.CategoryID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand();
                brand.setBrandID(rs.getString("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                Category category = new Category();
                category.setCategoryID(rs.getString("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                brand.setCategoryID(category);
                listBrandByCategory.add(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBrandByCategory;
    }

    public ArrayList<Brand> getBrandByCategory(String id) {
        ArrayList<Brand> listBrandByCategory = new ArrayList<>();
        try {
            String sql = "SELECT dbo.Brand.*, dbo.Category.CategoryName\n"
                    + "FROM dbo.Category INNER JOIN dbo.Brand ON dbo.Category.CategoryID = dbo.Brand.CategoryID\n"
                    + "WHERE dbo.Category.CategoryID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand();
                brand.setBrandID(rs.getString("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                Category category = new Category();
                category.setCategoryID(rs.getString("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                brand.setCategoryID(category);
                listBrandByCategory.add(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBrandByCategory;
    }

    public String getNameBrandAndCategoryByID(String id) {
        String sql = "SELECT dbo.Brand.BrandName, dbo.Category.CategoryName, dbo.Brand.CategoryID\n"
                + "FROM dbo.Brand INNER JOIN dbo.Category ON dbo.Brand.CategoryID = dbo.Category.CategoryID\n"
                + "WHERE dbo.Brand.BrandID = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String brandName = rs.getString("BrandName");
                String categoryName = rs.getString("CategoryName");
                String categoryID = rs.getString("CategoryID");
                return brandName + "/" + categoryName + "/" + categoryID;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getNameCategoryByID(String id) {
        String sql = "Select CategoryName from Category where CategoryID = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String categoryName = rs.getString("CategoryName");
                return categoryName;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getBrandIDfromName(String name) {
        String sql = "SELECT dbo.Brand.BrandID\n"
                + "FROM dbo.Brand\n"
                + "WHERE dbo.Brand.BrandName  = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int idBrand = rs.getInt("BrandID");
                return String.valueOf(idBrand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Material> getAllMaterial() {
        String sql = "SELECT * FROM dbo.Material";
        ArrayList<Material> listMaterial = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Material x = new Material();
                x.setMaterialID(rs.getString("MaterialID"));
                x.setMaterialName(rs.getString("MaterialName"));
                listMaterial.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMaterial;
    }

    public int insertBrand(String brandName, String categoryID) {
        String sql = "INSERT INTO dbo.Brand (\n"
                + "	BrandName,\n"
                + "	CategoryID\n"
                + ") VALUES ( \n"
                + "	?,\n"
                + "	? ) ";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brandName);
            statement.setString(2, categoryID);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) {
        BrandDAO dao = new BrandDAO();
        System.out.println(dao.getBrandIDfromName("Dream"));
    }
}
