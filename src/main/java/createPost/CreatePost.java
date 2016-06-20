/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createPost;

import comment.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thom
 */
@WebServlet(name = "CreatePost", urlPatterns = {"/CreatePost"})
public class CreatePost extends HttpServlet {


    
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

            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("userName");
            
            ArrayList<Comment> db;
            if (session.getAttribute("comments") == null) {
                db = new ArrayList<Comment>();
                Comment comment1 = new Comment("I think that pandas are the cutest animals.", "lucky1");
                Comment comment2 = new Comment("No, you are mistaken. Penguins are the cutiest", "mickey123");
                Comment comment3 = new Comment("Sloths are cute because of their toes.", "MarkyWalberg");
                Comment comment4 = new Comment("I am a potato.", "applesBananas");

                db.add(comment1);  db.add(comment2);
                db.add(comment3);  db.add(comment4);

            } else {
                db = (ArrayList<Comment>) session.getAttribute("comments");
            }
            
            String message = request.getParameter("message");
//            String user = request.getParameter("userName");
    
            if (message != null && !message.isEmpty()) {
                Comment newComment = new Comment(message, user);
                db.add(newComment);
            }

            Collections.sort(db, new Comparator<Comment>() {
                @Override
                public int compare(Comment o1, Comment o2) {
                    return o1.getLocalDateTime().compareTo(o2.getLocalDateTime());
                }
            });
            
            session.setAttribute("comments", db);                
            
            response.sendRedirect("viewPost.jsp");
            // return;
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
