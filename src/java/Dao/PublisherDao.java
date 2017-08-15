package Dao;

import Utils.DbUtil;
import DbObjects.Publisher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublisherDao {

    private Connection connection;

    public PublisherDao() {
        connection = DbUtil.getConnection();
    }

    public void addPublisher(Publisher publisher) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into publisher(name,address,phoneNumber) values (?, ?, ? )");
            // Parameters start with 1
            
                //preparedStatement.setInt(1, publisher.getPublisherId());
                preparedStatement.setString(1, publisher.getName());
                preparedStatement.setString(2, publisher.getAdress());
                preparedStatement.setString(3, publisher.getPhoneNumber() );
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePublisher(int publisherId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from publisher where publisher_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1,publisherId );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePublisher(Publisher publisher) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update publisher set name=?, address=?, phoneNumber=?" +
                            " where publisher_id=?");
            // Parameters start with 1
            
          
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.setString(2, publisher.getAdress());
            preparedStatement.setString(3,   publisher.getPhoneNumber());
            preparedStatement.setInt(4,   publisher.getPublisherId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Publisher> getAllPublisher() {
        List<Publisher> publishers = new ArrayList<Publisher>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from publisher");
            while (rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(rs.getInt("publisher_id"));
                publisher.setName(rs.getString("name"));
                publisher.setAdress(rs.getString("address"));
                publisher.setPhoneNumber(rs.getString("phoneNumber"));
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
              
        
        return publishers;
    }

    public Publisher getPublisherById(int authorId) {
        Publisher publisher = new Publisher();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from publisher where publisher_id=?");
            preparedStatement.setInt(1, authorId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                publisher.setPublisherId(rs.getInt("publisher_id"));
                publisher.setName(rs.getString("name"));
                publisher.setAdress(rs.getString("address"));
                publisher.setPhoneNumber(rs.getString("phoneNumber"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publisher;
    }
}