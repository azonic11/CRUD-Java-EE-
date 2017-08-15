/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbObjects;

import java.util.Date;


/**
 *
 * @author azoni
 */
public class Author {

    private Integer authorid;
    private String firstName;
    private String lastName;
    private Date date;

    
    public Integer getAuthorId() {
        return authorid;
    }

    public void setAuthorId(Integer authorid) {
        this.authorid = authorid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void getDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
