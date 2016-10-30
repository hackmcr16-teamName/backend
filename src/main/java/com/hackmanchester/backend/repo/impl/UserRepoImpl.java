package com.hackmanchester.backend.repo.impl;


import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.repo.UserRepo;
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
public class UserRepoImpl implements UserRepo {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User addUser(User user) {
        int id = 0;
        Connection conn = null;

        String sql = "INSERT INTO tblUser" +
                     "(firstname, surname,telephone)" +
                     "VALUES(?,?,?)";

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getSurname());
            ps.setString(3,user.getTelNo());
            id = ps.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }

        user.setUserID(id);
        return user;

    }

    public User getUser(int id) {
        return null;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();

        String sql = "SELECT * " +
                     "FROM tblInterest";

        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                userList.add(new User(rs.getInt("idInterest"), rs.getString("firstname"),
                        rs.getString("surname"),rs.getString("telephone"),rs.getInt("idBranch")));
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

    public void deletUser(int id) {

    }

    public void updateUser(User user) {

    }

    public List<Interest> getUserInterests()
    {

        List<Interest> intrList = new ArrayList<Interest>();

        Connection conn = null;

        String sql = "SELECT tblInterests.idInterest tblInterests.name " +
                "FROM tblInterests " +
                "INNER JOIN tblUserInterests ON tblInterests.idInterest = tblUserInterest.idInterest " +
                "INNER JOIN tblUserInterests ON tblUsers.idUsers = tblUserInterest.idUser";

        return intrList;
    }
}
