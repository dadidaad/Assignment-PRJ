package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO extends BaseDAO<Account> {

    public ArrayList<Account> getAll() {
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            String sql = "SELECT *"
                    + "  FROM [CustomerAccount]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("Username"));
                account.setPassword(rs.getString("Password"));
                account.setRole(rs.getString("ROLE"));
                listAccount.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccount;
    }
    public int createAccount(Account x) {
        int rs = 0;
        try {
            String sql = "Insert into [CustomerAccount]( [Username], [Password], [ROLE])values (?, ?, 'Customer')";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, x.getUsername());
            statement.setString(2, x.getPassword());
            rs = statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    public static void main(String[] args) {
        AccountDAO db = new AccountDAO();
        Account x = new Account();
        x.setUsername("babi");
        x.setPassword("hi");
        System.out.println(db.createAccount(x));
    }
}
