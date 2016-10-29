package com.hackmanchester.backend.repo.impl;


import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.repo.InterestRepo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


/**
 * Created by ben on 29/10/16.
 */
public class InterestImpl implements InterestRepo {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

    public Interest getInterest(int id) {


        return null;
    }

    public void deleterInterest(int id) {

    }

    public void updateInterest(Interest interest) {

    }
}
