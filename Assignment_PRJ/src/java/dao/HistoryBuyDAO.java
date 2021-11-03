package dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemHistoryBuy;

/**
 *
 * @author Admin
 */
public class HistoryBuyDAO extends BaseDAO<Object> {

    public int insertIntoHistoryBuyTable(String username, String productID, int quantity) {
        String sql = "INSERT INTO dbo.HistoryBuy (\n"
                + "	Username,\n"
                + "	ProductWithMaterialID,\n"
                + "	DateBuy,\n"
                + "	Quantity\n"
                + ") VALUES ( \n"
                + "	/* Username - NVARCHAR(50) */ ?,\n"
                + "	/* ProductWithMaterialID - INT */ ?,\n"
                + "	/* DateBuy - DATE */ /* Unable to insert value for unknown user-defined or CLR type */ ?,\n"
                + "	/* Quantity - INT */ ? ) ";
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, productID);
            statement.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
            statement.setInt(4, quantity);
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBuyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<ItemHistoryBuy> getItemByUsername(String username) {
        String sql = "SELECT *\n"
                + "FROM dbo.HistoryBuy\n"
                + "WHERE dbo.HistoryBuy.Username = ?";
        ArrayList<ItemHistoryBuy> listItem = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ItemHistoryBuy item = new ItemHistoryBuy();
                item.setUsername(username);
                item.setProductWithMaterialID(rs.getString("ProductWithMaterialID"));
                item.setDateBuy(rs.getTimestamp("DateBuy"));
                item.setQuantity(rs.getInt("Quantity"));
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBuyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public int getRecordOfItems() {
        String sql = "SELECT COUNT(*) AS total\n"
                + "FROM dbo.HistoryBuy";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int result = rs.getInt("total");
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBuyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        HistoryBuyDAO db = new HistoryBuyDAO();
        System.out.println(db.getRecordOfItems());
    }
}
