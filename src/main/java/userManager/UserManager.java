/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userManager;

/**
 *
 * @author Thom
 */
public class UserManager {
    private String userName;
    private String password;

    public UserManager(String un, String p) {
        userName = un;
        password = p;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String un) {
        userName = un;
    }

    public void setPassword(String p) {
        password = p;
    }
}
