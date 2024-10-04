package db;

import bo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.stream.Stream;

public class ItemDB extends Item {

    public static Collection getItems() {
        Vector v = new Vector<>();
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement("select * from t_items");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                int stock = rs.getInt("stock");
                v.addElement(new ItemDB(name, desc, i, stock));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }

    public static Collection getItemsByIds(ArrayList<Integer> ids) {
        if(ids != null) {
            Vector v = new Vector<>();
            try {

                Connection con = DBManager.getConnection();
                StringBuilder query = new StringBuilder("select * from t_items where t_items.id in (");
                for (int i = 0; i < ids.size()-1; i++) {
                    query.append("?,");
                }
                query.append("?)");
                PreparedStatement st = con.prepareStatement(query.toString());
                for (int i = 0; i < ids.size(); i++) {
                    st.setInt(i+1,ids.get(i));
                }
                ResultSet rs = st.executeQuery();

                while(rs.next()) {
                    for (int i = 0; i < Collections.frequency(ids,rs.getInt("id")); i++) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String desc = rs.getString("description");
                        int stock = rs.getInt("stock");

                        v.addElement(new ItemDB(name, desc, id,stock));
                    }
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return v;
        }
        return null;
    }

    public static Item getItemById(int id) {
        Item item = null;
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from t_items where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item = new ItemDB(rs.getString("name"), rs.getString("description"), rs.getInt("id"),rs.getInt("stock"));
                int i = rs.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private ItemDB(String name, String description, int id,int stock) {
        super(name, description, id, stock);
    }
}
