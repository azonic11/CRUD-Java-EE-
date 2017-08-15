package Dao;

import DbObjects.BookAuthor;
import Utils.DbUtil;
import DbObjects.Publisher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookAutorDao {

    private Connection connection;

    public BookAutorDao() {
        connection = DbUtil.getConnection();
    }

    public void addBookAutor(BookAuthor bookAuthor) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into book_autor(book_id,autor_id) values (?, ?)");
            // Parameters start with 1
            
                //preparedStatement.setInt(1, publisher.getPublisherId());
                preparedStatement.setInt(1, bookAuthor.getBookId());
                preparedStatement.setInt(2, bookAuthor.getAuthorId());
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookAutho(BookAuthor bookAuthot) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from book_autor where book_id=? and autor_id=?");
             
            // Parameters start with 1
            preparedStatement.setInt(1,bookAuthot.getBookId());
            preparedStatement.setInt(2,bookAuthot.getAuthorId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookAutho(int book_id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from book_autor where book_id=? ");
             
            // Parameters start with 1
            preparedStatement.setInt(1,book_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<BookAuthor> getAllBookAuthor() {
        List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from book_autor");
            while (rs.next()) {
               BookAuthor bookAuthor=new BookAuthor();
                bookAuthor.setAuthorId(rs.getInt("autor_id"));
                bookAuthor.setBookId(rs.getInt("book_id"));

                bookAuthors.add(bookAuthor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hjuston2");
        }
              
        
        return bookAuthors;
    }
    
    public List<Integer> getAuthorIdByBookId(int bookId){
         List<Integer> authorId = new ArrayList<Integer>();
         
          List<BookAuthor> all =getAllBookAuthor();
          BookAuthor bookAuthor;
          Iterator iter=all.iterator();
          try{
          while(iter.hasNext()){
              
              bookAuthor=(BookAuthor)iter.next();
              if(bookAuthor.getBookId()==bookId){
                  authorId.add(Integer.valueOf(bookAuthor.getAuthorId()));
              }
          }
          }catch(Exception e){System.out.println("hjuston");}
          
         return authorId;
    }
    
    public boolean orExist(BookAuthor bookAuthor) throws SQLException{
        Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from book_autor where book_id='" + bookAuthor.getBookId() + "'"
                    + " and autor_id= '" + bookAuthor.getAuthorId() + "' ");  
         
        return rs.absolute(0);
    }
}