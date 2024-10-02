package db;

import bo.Item;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Item {

    public static Collection getItems() {
        Vector v = new Vector<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from t_items");

            while (rs.next()) {
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");

                v.addElement(new ItemDB(name, desc, i));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }

    public static Item getItemById(int id) {
        Item item = null;
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from t_items where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item = new ItemDB(rs.getString("name"), rs.getString("description"), rs.getInt("id"));
                int i = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private ItemDB(String name, String description, int id) {
        super(name, description, id);
    }
}
