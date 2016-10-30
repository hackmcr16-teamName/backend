package com.hackmanchester.backend.repo.impl;


import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.repo.UserRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 * Created by ben on 30/10/16.
 */
@Repository
public class UserRepoImpl implements UserRepo {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional
    public User addUser(User user) {
        int id = 0;
        Connection conn = null;

        String sql = "INSERT INTO tblUsers " +
                     "(name,telephone,idBranch,base64Image)" +
                     "VALUES(?,?,1,?)";

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getTelNo());
            ps.setString(3, user.getBase64Image());
            id = ps.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }

        user.setUserID(id);
        return user;

    }

    public User getUser(int id)
    {
        User user = null;
        String sql = "SELECT * " +
                     "FROM tblUsers WHERE idUsers = ?";

        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
                user = new User(id, rs.getString("name"), rs.getString("telephone"), rs.getInt("idBranch"), rs.getString("base64Image"));

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return user;
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();

        String sql = "SELECT * " +
                     "FROM tblUsers";

        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                userList.add(new User(rs.getInt("idInterest"), rs.getString("name"),rs.getString("telephone"),rs.getInt("idBranch")));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return userList;
    }

    public void deleteUser(int id)
    {

    }

    public void updateUser(User user)
    {

    }

    @Transactional
    public void addUserInterest(int userID, Interest interest)
    {
         String sql = "INSERT INTO tblUserInterests (idUsers, idInterests) VALUES (?,?)";

        Connection conn = null;
        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, interest.getInterestID());
            ps.executeUpdate();

            ps.close();

        } catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Transactional
    public List<Interest> getUsersInterests(int id)
    {

        List<Interest> intrList = new ArrayList<Interest>();

        Connection conn = null;

//        String sql = "SELECT tblInterest.idInterest, tblInterest.name " +
//                "FROM tblInterest, tblUserInterests, tblUsers " +
//                "WHERE  tblUserInterests.idInterest = tblInterest.idInterest  " +
//                "AND tblUsers.idUsers = tblUserInterests.idUsers WHERE tblUsers.idUsers = ?";

        String sql =
                "SELECT tblInterest.idInterest, tblInterest.name " +
                        "FROM tblInterest " +
                        "INNER JOIN tblUserInterests " +
                        "ON tblInterest.idInterest = tblUserInterests.idInterests " +
                        "INNER JOIN tblUsers " +
                        "ON tblUserInterests.idUsers = tblUsers.idUsers " +
                        "WHERE tblUsers.idUsers = ?;";



        ResultSet rs = null;
        PreparedStatement ps = null;

        try
        {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while(rs.next())
                intrList.add(new Interest(rs.getInt("idInterest"), rs.getString("name")));

            ps.close();
            rs.close();

        } catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return intrList;
    }

    @Transactional
    public List<User> getUsersWithSimilarInterests(int id)
    {
        List<User> users = new ArrayList<User>();

        String sql = "SELECT * FROM tblUsers INNER JOIN tblUserInterests ON tblUsers.idUsers = tblUserInterests.idUsers WHERE tblUserInterests.idInterests IN (SELECT idInterests FROM tblUserInterests WHERE idUsers = ?) AND tblUsers.idUsers != ?;";

        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
                users.add(new User(rs.getInt("idUsers"), rs.getString("name"), rs.getString("telephone"), rs.getInt("idBranch"), rs.getString("base64Image")));

            rs.close();
            ps.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }
}
