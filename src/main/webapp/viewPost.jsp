<%-- 
    Document   : viewPost
    Created on : Jun 18, 2016, 6:53:04 PM
    Author     : Thom
--%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="comment.Comment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>What's the cutest animal??</h1>
        <%
        
            ArrayList<Comment> comments = (ArrayList<Comment>) session.getAttribute("comments"); 
            
            
            
//            for (Comment comment : comments){
            for (int i = comments.size() - 1; i >= 0 ; i--){

                out.println("<b>Comment:</b> " + comments.get(i).getComment() + "<br />");
                out.println("<b>User:</b>    " + comments.get(i).getUser() + "<br />");
                out.println("<b>Time:</b>    " + comments.get(i).getLocalDateTime() + "<br />");
                out.println("<br />");
            }
        %>
        <a href="newPost.html">comment</a>

    </body>
</html>
