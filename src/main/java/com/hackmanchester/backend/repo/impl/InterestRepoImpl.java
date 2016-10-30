package com.hackmanchester.backend.repo.impl;


import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.repo.InterestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
 * Created by ben on 29/10/16.
 */
//@Repository("interestRepo")
public class InterestRepoImpl implements InterestRepo {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Transactional
    public int insert(Interest interest) {

        int id = 0;
        String sql = "INSERT INTO tblInterest" +
                    "(name)" +"VALUES(?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,interest.getName());
            id = ps.executeUpdate();

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
        return id;

    }

    @Transactional
    public Interest getInterest(int id) {

        Interest intr = null;

        String sql = "SELECT * " +
                "FROM tblInterest WHERE idInterest = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                intr = new Interest(id, rs.getString("name"));
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


        return intr;
    }

    @Transactional
    public List<Interest> getAllInterest() {

        List<Interest> intrList = new ArrayList<Interest>();

        String sql = "SELECT * " +
                     "FROM tblInterest";

        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                intrList.add(new Interest(rs.getInt("idInterest"), rs.getString("name")));
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

        return intrList;
    }

    @Transactional
    public void deleteInterest(int id) {

        Connection conn = null;
        String sql = "DELETE FROM tblInterest " +
                     "WHERE idInterest = ?";
        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Transactional
    public void updateInterest(Interest interest) {

        Connection conn = null;
        String sql = "UPDATE tblInsert " +
                     "SET name = ?" +
                     "WHERE idInsert = ? ";

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,interest.getName());
            ps.setInt(2,interest.getInterestID());
            ps.executeQuery();

            ps.close();

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
