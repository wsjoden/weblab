package db;

import bo.User;

import java.sql.*;

public class UserDB extends User {

    public static boolean login(String name, String password) {
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from t_users where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            int grej = rs.getFetchSize();


            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    protected UserDB(String name, String password) {
        super(name, password);
    }
}
