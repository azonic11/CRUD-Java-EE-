/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Dao.AuthorDao;
import Dao.BookAutorDao;
import Dao.BookDao;
import DbObjects.Author;
import DbObjects.Book;
import DbObjects.BookAuthor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author azoni
 */
public class SetOfAuthors {
    private AuthorDao autDao;
    private BookDao bookDao;
    private BookAutorDao boAuDao;
    
    private int id;
    private String autorsString;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    private String bookId;
    private  List<Integer> autorsId=new ArrayList<Integer>();
    private  List<String> autorsFullName=new ArrayList<String>();

            
    public List<Integer> getAutorsId() {
        return autorsId;
    }

    public void setAutorsId(List<Integer> autorsId) {
        this.autorsId = autorsId;
    }

    public List<String> getAutorsFullName() {
        return autorsFullName;
    }

    public void setAutorsFullName(List<String> autorsFullName) {
        this.autorsFullName = autorsFullName;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutorsString() {
        return autorsString;
    }

    public void setAutorsString(String autorsString) {
        this.autorsString = autorsString;
    }
    
    public SetOfAuthors(){
    }
    
     private SetOfAuthors(int id, String autorsString,List<Integer> autorsId, List<String> autorsFullName){
      this.id=id;
      this.autorsString=autorsString;
      this.autorsId=autorsId;
      
      this.autorsFullName=autorsFullName;
    }
    
    
    public List<SetOfAuthors> getAuthorsList(){
         autDao=new AuthorDao();
         bookDao=new BookDao();
         boAuDao=new BookAutorDao();
        
         List<BookAuthor> bookAuthors = boAuDao.getAllBookAuthor();
         List<Book>books =bookDao.getAllBook();
         List<Author> authors=autDao.getAllAuthor();
         List<SetOfAuthors> res=new ArrayList<SetOfAuthors>();
         
         String buff="";
         Iterator iter=books.iterator();
         BookAuthor ba;
         Author autor;
         Book book;
                autorsId.clear();
                  autorsFullName.clear();
         
         while(iter.hasNext())
         {
          book=(Book)iter.next();

              Iterator iter2=bookAuthors.iterator();
                  while(iter2.hasNext()){
                      ba=(BookAuthor)iter2.next();
                        if(book.getBookId()==ba.getBookId()){
                            Iterator iter3=authors.iterator();
                                while(iter3.hasNext()){
                                    autor=(Author)iter3.next();
                                    
                                    if(ba.getAuthorId()==autor.getAuthorId()){
                                       buff=buff+autor.getFirstName().trim()+" "+autor.getLastName().trim()+", ";
                                       autorsId.add(autor.getAuthorId());
                                       autorsFullName.add(autor.getFirstName().trim()+" "+autor.getLastName().trim());
                                        
                                    }
                                    
                                    
                                }
                         
                                
                        }
                 
                  }
                  res.add(new SetOfAuthors(book.getBookId(),buff,autorsId,autorsFullName));
                  buff="";
                           }
             
         
         return res;
    }
}
