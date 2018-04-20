package loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import date.CurrentDate;
import dbUtil.dbConnection;

public class LoginModel {

    Connection connection;

    public LoginModel(){
        try {
            this.connection = dbConnection.getConnection();
        }

        catch(SQLException ex){
            ex.printStackTrace();
        }

        if (this.connection == null) {
            System.exit(1);
        }

    }

    public boolean isDatabaseConnected() {
        return this.connection != null;
    }

    public boolean isLogin(String email, String password, String loginType) throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;
        CurrentDate currentDate = new CurrentDate();
        String date = "'" + currentDate.getDate() + "'";
        String sql = "SELECT * FROM " + loginType + " where email = ? and password = ? and expiration_date >= " + date;

        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);

            rs = pr.executeQuery();

            if(rs.next()) {
                return true;
            }

            return false;

        }
        catch (SQLException ex){
            return false;
        }

        finally {
            pr.close();
            rs.close();
        }

    }

    public boolean hasUserAcct(String email, String loginType) throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " + loginType + " where email = ?";

        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, email);

            rs = pr.executeQuery();

            if(rs.next()) {
                return true;
            }

            return false;

        }
        catch (SQLException ex){
            return false;
        }

        finally {
            pr.close();
            rs.close();
        }
    }

    public boolean hasCorrectPassword(String email, String password, String loginType) throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " + loginType + " where email = " + email + " and password = ?";

        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, password);

            rs = pr.executeQuery();

            if(rs.next()) {
                return true;
            }

            return false;

        }
        catch (SQLException ex){
            return false;
        }

        finally {
            pr.close();
            rs.close();
        }
    }

    public boolean hasActiveAcct(String email, String password, String loginType) throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;
        CurrentDate currentDate = new CurrentDate();
        String date = "'" + currentDate.getDate() + "'";
        String sql = "SELECT * FROM " + loginType + " where email = " + email + " and password = " + password + " and expiration_date >= " + date;

        try{
            pr = this.connection.prepareStatement(sql);
            rs = pr.executeQuery();

            if(rs.next()) {
                return true;
            }

            return false;

        }
        catch (SQLException ex){
            return false;
        }

        finally {
            pr.close();
            rs.close();
        }
    }
}
