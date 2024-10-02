package bo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler extends HttpServlet {
    public static Collection<ItemInfo> getItems(){
        Collection c = Item.getItems();
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext();) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(),item.getDescription(),item.getId()));
        }
        return items;
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("itemId"));
        System.out.println("added to cart: " + id);
    }
}
