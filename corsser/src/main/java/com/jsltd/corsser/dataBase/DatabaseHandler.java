package com.jsltd.corsser.dataBase;

import com.jsltd.corsser.Art;
import com.jsltd.corsser.User;
import com.jsltd.corsser.dataBase.Configs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:postgresql://127.0.0.1:5432/corsses";

        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);

        return dbConnection;
    }

    public static Connection ConnectDB() {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/corsses","postgres","ntktw2002");
            // JOptionPane.showMessageDialog(null, "Connection Established");
            return connection;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void signUpUser(User user)
    {
        String insert = "INSERT INTO "+Const.USER_TABLE+"("+Const.USER_NAME+","+Const.USER_LOGIN+","+
                Const.USER_PASSWORD+","+Const.USER_ROLE+")"+"VALUES(?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getFirstname());
            prSt.setString(2,user.getUsername());
            prSt.setString(3,user.getPassword());
            prSt.setString(4,user.getRole());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getUser(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static ObservableList<Art> getDataArt()  {
        Connection conn = ConnectDB();
        ObservableList<Art> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM arts");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                list.add(new Art(rs.getString("id"), rs.getString("artName"), rs.getString("artCount"), rs.getString("price"), rs.getString("category"),  rs.getString("author")));
            }
        }catch (Exception e){
        }
        return list;
    }
}
