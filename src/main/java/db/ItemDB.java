package db;

import bo.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Item {

    public static Collection getItems() {
        Vector v = new Vector<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from t_items");

            while(rs.next()) {
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");

                v.addElement(new ItemDB(name,desc,i));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }
    private ItemDB(String name, String description, int id){
        super(name,description,id);
    }
}
