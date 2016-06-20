/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userManager.UserManager;

/**
 *
 * @author Thom
 */
@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            ArrayList<UserManager> db = new ArrayList<UserManager>();
            UserManager user1 = new UserManager("lucky1", "Pickles");
            UserManager user2 = new UserManager("applesBananas", "oranges");
            UserManager user3 = new UserManager("mickey123", "pluto");
            UserManager user4 = new UserManager("MarkyWalburg", "password");
            db.add(user1);  db.add(user2);
            db.add(user3);  db.add(user4);
            
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            UserManager checkuser = new UserManager(userName, password);
            
            for (UserManager user : db) {
                out.println("Username: " + user.getUserName() + "<br />");
                out.println("Password: " + user.getPassword() + "<br />");
                if (userName.equals(user.getUserName())) {
                    if (password.equals(user.getPassword())){
                        HttpSession session = request.getSession();
                        session.setAttribute("userName", userName);
                        response.sendRedirect("newPost.html");
                        return;
                    }
                }
            }
            // no users found
            response.sendRedirect("invalidLogin.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
