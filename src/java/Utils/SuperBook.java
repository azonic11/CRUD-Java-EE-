/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Dao.BookAutorDao;
import DbObjects.Book;
import java.util.List;

/**
 *
 * @author azoni
 */
public class SuperBook extends Book{
    
    
    
    public SuperBook(){
        super();
         BookAutorDao xx=new BookAutorDao();
           setauthorsId(xx.getAuthorIdByBookId(super.getBookId()));
    }
    
    private  List<Integer> authorsId ;

    public List<Integer> getauthorsId() {
        return authorsId;
    }

    public void setauthorsId(List<Integer> author) {
        this.authorsId = author;
    }
    
}
