package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Brand;
import model.Material;
import model.Product;
import model.ProductWithMaterial;

/**
 *
 * @author Admin
 */
public class ProductDAO extends BaseDAO<Object> {

    public ArrayList<Product> getAllProducts(int pageIndex, int pageSize) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            String sql = "SELECT ProductID, ProductName, [Description], BrandID, BrandName\n"
                    + "FROM (SELECT ROW_NUMBER() OVER (ORDER  BY ProductID) AS RowNum, ProductID, ProductName, [Description], dbo.Product.BrandID, dbo.Brand.BrandName FROM dbo.Product INNER JOIN dbo.Brand ON dbo.Product.BrandID = dbo.Brand.BrandID) AS tblProduct\n"
                    + "WHERE RowNum >= ((?-1)*?)+1 AND RowNum <= ?*?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pageIndex);
            statement.setInt(2, pageSize);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageIndex);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                Brand brand = new Brand();
                brand.setBrandID(rs.getString("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                product.setBrand(brand);
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listProduct;
    }

    public ArrayList<Product> getProductByBrand(int pageIndex, int pageSize, String BrandID) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            String sql = "SELECT ProductID, ProductName, [Description], BrandID, BrandName\n"
                    + "FROM (SELECT ROW_NUMBER() OVER (ORDER  BY dbo.Product.BrandID) AS RowNum, ProductID, ProductName, [Description], dbo.Product.BrandID, dbo.Brand.BrandName FROM dbo.Product INNER JOIN dbo.Brand ON dbo.Product.BrandID = dbo.Brand.BrandID WHERE dbo.Product.BrandID = ?) AS tblProduct\n"
                    + "WHERE RowNum >= ((?-1)*?)+1 AND RowNum <= ?*?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BrandID);
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageSize);
            statement.setInt(5, pageIndex);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                Brand brand = new Brand();
                brand.setBrandID(rs.getString("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                product.setBrand(brand);
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listProduct;
    }

    public ArrayList<Product> getProductByCategory(int pageIndex, int pageSize, String CatergoryID) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            String sql = "SELECT ProductID, ProductName, [Description], BrandID, BrandName\n"
                    + "FROM (SELECT ROW_NUMBER() OVER (ORDER  BY dbo.Product.BrandID) AS RowNum, ProductID, ProductName, [Description], dbo.Product.BrandID, dbo.Brand.BrandName FROM dbo.Product INNER JOIN dbo.Brand ON dbo.Product.BrandID = dbo.Brand.BrandID WHERE dbo.Brand.CategoryID = ?) AS tblProduct\n"
                    + "WHERE RowNum >= ((?-1)*?)+1 AND RowNum <= ?*?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, CatergoryID);
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageSize);
            statement.setInt(5, pageIndex);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                Brand brand = new Brand();
                brand.setBrandID(rs.getString("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                product.setBrand(brand);
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listProduct;
    }

    public int getNoOfRecordProduct() {
        try {
            String sql = "SELECT COUNT(*) AS total\n"
                    + "FROM dbo.Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return 0;
    }

    public int getNoOfRecordProductbyBrand(String BrandID) {
        try {
            String sql = "SELECT COUNT(*) AS total\n"
                    + "FROM dbo.Product WHERE BrandID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BrandID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return 0;
    }

    public int getNoOfRecordProductbyCategory(String CategoryID) {
        try {
            String sql = "SELECT COUNT(*) AS total\n"
                    + "FROM dbo.Product INNER JOIN dbo.Brand ON dbo.Product.BrandID = dbo.Brand.BrandID\n"
                    + "WHERE CategoryID = ?\n"
                    + "GROUP BY CategoryID";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, CategoryID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return 0;
    }

    public ArrayList<ProductWithMaterial> getProductWithMaterial(Product product) {
        ArrayList<ProductWithMaterial> listProductWithMaterial = new ArrayList<>();
        try {
            String sql = "SELECT dbo.ProductWithMaterial.*, dbo.Material.MaterialName\n"
                    + "FROM dbo.ProductWithMaterial INNER join dbo.Material ON dbo.ProductWithMaterial.MaterialID = dbo.Material.MaterialID\n"
                    + "WHERE dbo.ProductWithMaterial.ProductID = ?\n"
                    + "ORDER BY MaterialName";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getProductID());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ProductWithMaterial productMaterial = new ProductWithMaterial();
                productMaterial.setProductWithMaterialID(rs.getString("ProductWithMaterialID"));
                productMaterial.setProductID(rs.getString("ProductID"));
                productMaterial.setImgSrc(rs.getString("ImageProduct"));
                productMaterial.setProductPrice(rs.getString("ProductPrice"));
                Material material = new Material();
                material.setMaterialID(rs.getString("MaterialID"));
                material.setMaterialName(rs.getString("MaterialName"));
                productMaterial.setMaterial(material);
                listProductWithMaterial.add(productMaterial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listProductWithMaterial;
    }

    public ArrayList<ProductWithMaterial> getAllProductWithMaterial() {
        ArrayList<ProductWithMaterial> listProductWithMaterial = new ArrayList<>();
        try {
            String sql = "SELECT dbo.ProductWithMaterial.*, dbo.Product.ProductName, dbo.Product.Description, dbo.Product.BrandID, dbo.Material.MaterialName\n"
                    + "FROM (dbo.ProductWithMaterial INNER JOIN dbo.Material ON dbo.ProductWithMaterial.MaterialID = dbo.Material.MaterialID) INNER JOIN dbo.Product ON dbo.Product.ProductID = dbo.ProductWithMaterial.ProductID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ProductWithMaterial productMaterial = new ProductWithMaterial();
                productMaterial.setProductWithMaterialID(rs.getString("ProductWithMaterialID"));
                productMaterial.setProductID(rs.getString("ProductID"));
                productMaterial.setDescription(rs.getString("Description"));
                productMaterial.setProductName(rs.getString("ProductName"));
                productMaterial.setImgSrc(rs.getString("ImageProduct"));
                productMaterial.setProductPrice(rs.getString("ProductPrice"));
                Material material = new Material();
                material.setMaterialID(rs.getString("MaterialID"));
                material.setMaterialName(rs.getString("MaterialName"));
                productMaterial.setMaterial(material);
                listProductWithMaterial.add(productMaterial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listProductWithMaterial;
    }

    public ProductWithMaterial getProductMaterialByID(String id) {
        String sql = "SELECT dbo.ProductWithMaterial.*, dbo.Product.ProductName, dbo.Product.Description, dbo.Product.BrandID, dbo.Material.MaterialName\n"
                + "FROM (dbo.ProductWithMaterial INNER JOIN dbo.Material ON dbo.ProductWithMaterial.MaterialID = dbo.Material.MaterialID) INNER JOIN dbo.Product ON dbo.Product.ProductID = dbo.ProductWithMaterial.ProductID\n"
                + "WHERE dbo.ProductWithMaterial.ProductWithMaterialID  = ? ";
        ProductWithMaterial x = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                x = new ProductWithMaterial();
                x.setProductWithMaterialID(rs.getString("ProductWithMaterialID"));
                x.setProductID(rs.getString("ProductID"));
                x.setImgSrc(rs.getString("ImageProduct"));
                x.setProductPrice(rs.getString("ProductPrice"));
                x.setProductName(rs.getString("ProductName"));
                x.setDescription(rs.getString("Description"));
                Material material = new Material();
                material.setMaterialID(rs.getString("MaterialID"));
                material.setMaterialName(rs.getString("MaterialName"));
                x.setMaterial(material);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public String getProductNamefromProductMaterial(String id) {
        String sql = "SELECT dbo.ProductWithMaterial.*, dbo.Product.ProductName\n"
                + "FROM dbo.Product INNER JOIN dbo.ProductWithMaterial ON dbo.Product.ProductID =  dbo.ProductWithMaterial.ProductID\n"
                + "WHERE dbo.ProductWithMaterial.ProductWithMaterialID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String ProductName = rs.getString("ProductName");
                return ProductName;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getIDProductFromName(String name) {
        String sql = "SELECT TOP 1 dbo.Product.ProductID\n"
                + "FROM dbo.Product\n"
                + "WHERE dbo.Product.ProductName = ?";
        String id="";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getString("ProductID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(id);
    }

    public int deleteProductWithMaterial(String id) {
        String sql = "DELETE FROM dbo.ProductWithMaterial\n"
                + "WHERE dbo.ProductWithMaterial.ProductWithMaterialID = ?";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateProductWithMaterial(String id, String price, String imgSrc) {
        String sql = "UPDATE dbo.ProductWithMaterial SET ImageProduct = ?, ProductPrice = ? WHERE ProductWithMaterialID = ?";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, imgSrc);
            statement.setString(2, price);
            statement.setString(3, id);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateProduct(String id, String Desc) {
        String sql = "UPDATE dbo.Product SET [Description] = ? WHERE ProductID = ? ";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Desc);
            statement.setString(2, id);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int insertProduct(String name, String desc, int brandID) {
        String sql = "INSERT INTO dbo.Product ("
                + "	ProductName,"
                + "	Description,"
                + "	BrandID"
                + ") VALUES ( "
                + "	 ?,"
                + "	 ?,"
                + "	?) ";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setInt(3, brandID);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int insertProductWithMaterial(int idProduct, String imgSrc, String productPrice, int MaterialID) {
        String sql = "INSERT INTO dbo.ProductWithMaterial (\n"
                + "	ProductID,\n"
                + "	ImageProduct,\n"
                + "	ProductPrice,\n"
                + "	MaterialID\n"
                + ") VALUES ( \n"
                + "	/* ProductID - int */ ?,\n"
                + "	/* ImageProduct - nvarchar(255) */ ?,\n"
                + "	/* ProductPrice - money */ ?,\n"
                + "	/* MaterialID - int */ ? )  ";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProduct);
            statement.setString(2, imgSrc);
            statement.setString(3, productPrice);
            statement.setInt(4, MaterialID);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) {
        ProductDAO db = new ProductDAO();
        System.out.println(db.insertProductWithMaterial(1, "hello", "10000", 1));
    }
}
