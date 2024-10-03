package bo;

import db.UserDB;

public class User {
    private String name;
    private String password;

    static public boolean login(String name, String password) {
        return UserDB.login(name,password);
    }
    protected User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
