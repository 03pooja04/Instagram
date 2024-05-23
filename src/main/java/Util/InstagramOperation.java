package Util;

import ConnectionHelper.CreateConnection;
import Model.Instagram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstagramOperation implements InstagramInterface {

    private static Connection con= CreateConnection.createconnection();
    private  static String createQuery="insert into instagram values(?,?,?,?,?,?)";
    private  static String selectQuery="select user_password from instagram where user_name=? or user_email=? or user_mobile_no=?";


    @Override
    public int createAcoount(Instagram i) {
        try {
            PreparedStatement pstmt=con.prepareStatement(createQuery);
            pstmt.setInt(1,0);
            pstmt.setString(2,i.getUserName());
            pstmt.setString(3,i.getUserEmailId());
            pstmt.setString(4,i.getUserMobileNo());
            pstmt.setString(5,i.getUserPassword());
            pstmt.setString(6, "ACTIVATE");
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public String selectData(Instagram i1) {
        try {
            PreparedStatement pstmt=con.prepareStatement(selectQuery);
            pstmt.setString(1,i1.getUserName());
            pstmt.setString(2,i1.getUserEmailId());
            pstmt.setString(3,i1.getUserMobileNo());
            ResultSet rs= pstmt.executeQuery();
            while (rs.next())
            {
                String password= rs.getString(1);
                return password;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  selectQuery;

    }
    public int updateStatus(Instagram i1) {
        try {
            String updateStatusQuery = "UPDATE instagram SET status = ? WHERE user_name = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateStatusQuery);
            updateStmt.setString(1, "NOT_Activate");
            updateStmt.setString(2, i1.getUserName());
            int count=updateStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}