        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import java.time.LocalDateTime;

/**
 *
 * @author Thom
 */
public class Comment {
    String comment;
    String user;
    LocalDateTime date;

    public Comment(String c, String u) {
        comment = c;
        user = u;
        date = LocalDateTime.now();
    }

    public String getComment() {
        return comment;
    }

    public String getUser() {
        return user;
    }

    public String getLocalDateTime() {
        return date.toString();
    }
}
