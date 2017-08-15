package Dao;

import Utils.DbUtil;
import DbObjects.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private Connection connection;

    public BookDao() {
        connection = DbUtil.getConnection();
    }

    public void addBook(Book book) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into book(publisher_id,title,numOfPage,price,description) values (?,?,?,?,?)");
            // Parameters start with 1
            
                //preparedStatement.setInt(1, book.getBookId());
                preparedStatement.setInt(1, book.getPublisherId());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setInt(3, book.getNumOfPage());
               
                preparedStatement.setFloat(4, book.getPrice());
                preparedStatement.setString(5,book.getDescription());
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from book where book_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1,bookId );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update book set publisher_id=?, title=?,  numOfPage=? " +
                            " , price=? , description=? where book_id=?");
            // Parameters start with 1
            
          
            preparedStatement.setInt    (1,   book.getPublisherId());
            preparedStatement.setString (2,   book.getTitle());
            preparedStatement.setInt    (3,   book.getNumOfPage());
          
            preparedStatement.setFloat  (4,   book.getPrice());
            preparedStatement.setString (5,   book.getDescription());
            preparedStatement.setInt    (6,   book.getBookId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error: "+ e.getMessage());
        }
    }

    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<Book>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from book");
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setPublisherId(rs.getInt("publisher_id"));
                book.setTitle(rs.getString("title"));
                book.setNumOfPage(rs.getInt("numOfPage"));
               
                book.setPrice(rs.getFloat("price"));
                book.setDescription(rs.getString("description"));
               
               
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
              
        
        return books;
    }

    public Book getBookById(int authorId) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from book where book_id=?");
            preparedStatement.setInt(1, authorId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                book.setBookId(rs.getInt("book_id"));
                book.setPublisherId(rs.getInt("publisher_id"));
                book.setTitle(rs.getString("title"));
                book.setNumOfPage(rs.getInt("numOfPage"));
                book.setPrice(rs.getFloat("price"));
                book.setDescription(rs.getString("description"));
               
               
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
}