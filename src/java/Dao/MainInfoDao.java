package Dao;

import Utils.DbUtil;
import DbObjects.Book;
import DbObjects.MainInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainInfoDao {

    private Connection connection;

    public MainInfoDao() {
        connection = DbUtil.getConnection();
    }


    
    

    public List<MainInfo> getMainInfo() {
        List<MainInfo> mainInfos = new ArrayList<MainInfo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from book_info");
            while (rs.next()) {
                MainInfo mainInfo=new MainInfo();
                
                mainInfo.setAuthorId(rs.getInt("autorId"));
                mainInfo.setAuthor(rs.getString("autor"));
                mainInfo.setBookId(rs.getInt("bookId"));
                mainInfo.setTitle(rs.getString("book"));
                mainInfo.setPrice(rs.getFloat("price"));
                mainInfo.setPublisher(rs.getString("publisher"));
                mainInfo.setPublisherId(rs.getInt("publisherId"));
             

        

              mainInfos.add(mainInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erron in DEO MAINInfo ");
           
        }
              
        
        return mainInfos;
    }

    public Book getMainInfoById(int mainInfoId) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from book_info where book_id=?");
            preparedStatement.setInt(1, mainInfoId);
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