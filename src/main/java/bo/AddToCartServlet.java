package bo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ui.ItemInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "addToCartServlet", value = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static Collection<ItemInfo> cart = new ArrayList<>();

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();

        Collection<ItemInfo> cart = (Collection<ItemInfo>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart); // Create cart if it doesn't exist
        }

        int id = Integer.parseInt(req.getParameter("itemId"));
        //System.out.println("added to cart: " + id);

        Item item = Item.getItemById(id);
        if (item != null) {
            cart.add(new ItemInfo(item.getName(), item.getDescription(), item.getId(), item.getStock()));
        }

        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();

        Collection<Integer> cart = (Collection<Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Integer>();
            session.setAttribute("cart", cart); // Create cart if it doesn't exist
        }

        int id = Integer.parseInt(req.getParameter("itemId"));
        //System.out.println("added to cart: " + id);

        cart.add(id);

        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Collection<ItemInfo> getCart(){return cart;}
}
