package bo;

import db.UserDB;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserHandler {
    static public boolean login(String name, String password) {
        return User.login(name,password);
    }

}
