package Dao;

import Utils.DbUtil;
import DbObjects.Author;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao{

    private Connection connection;

    public AuthorDao() {
        connection = DbUtil.getConnection();
    }

    public void addAuthor(Author author) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into autor(first_name,last_name,birth_day) values (?, ?, ? )");
            // Parameters start with 1
            try{
                java.sql.Date sqlDate = new java.sql.Date(author.getDate().getTime());

                //preparedStatement.setInt(1, author.getAuthorId());
                preparedStatement.setString(1, author.getFirstName());
                preparedStatement.setString(2, author.getLastName());
                preparedStatement.setDate(3, sqlDate );
                preparedStatement.executeUpdate();
                
            }catch(Exception e){System.out.println(e.getMessage());}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int authorId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from autor where autor_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, authorId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAuthor(Author author) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update autor set first_name=?, last_name=?, birth_day=?" +
                            " where autor_id=?");
            // Parameters start with 1
             try{
            java.sql.Date sqlDate = new java.sql.Date(author.getDate().getTime());
            
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setDate(3,   sqlDate );
            preparedStatement.setInt(4,   author.getAuthorId());
            
            preparedStatement.executeUpdate();
             }catch(Exception e){System.out.println(e.getMessage());}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAllAuthor() {
        List<Author> authors = new ArrayList<Author>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from autor");
            while (rs.next()) {
                Author author = new Author();
                author.setAuthorId(Integer.valueOf(rs.getInt("autor_id")));
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));
                author.setDate(rs.getDate("birth_day"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
              
        
        return authors;
    }

    public Author getAuthorById(int authorId) {
        Author author = new Author();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from autor where autor_id=?");
            preparedStatement.setInt(1, authorId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                author.setAuthorId(Integer.valueOf(rs.getInt("autor_id")));
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));
                author.setDate(rs.getDate("birth_day"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }
}