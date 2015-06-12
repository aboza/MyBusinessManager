/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Role;
import Beans.User;
import JDBC.OracleConnectionFactory;
import Utils.Constants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlexisDev
 */
public class DAOUser {

    public ArrayList<User> getAllUsers() {
        try {
            ArrayList<User> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_USERS);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                User actualUser;
                actualUser = new User();
                actualUser.setId(var_resultSet.getInt("USER_ID"));
                actualUser.setUserName(var_resultSet.getString("USERNAME"));
                Role actualRole;
                actualRole = new Role();
                actualRole.setId(var_resultSet.getInt("ROLE_ID"));
                actualRole.setName(var_resultSet.getString("ROLE_NAME"));
                actualUser.setRole(actualRole);
                resultList.add(actualUser);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public User getSingleUserById(int userId) {
        try {
            User userBean = null;
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_USER_BY_ID);
            statement.setInt(1, userId);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                userBean = new User();
                userBean.setId(var_resultSet.getInt("USER_ID"));
                userBean.setUserName(var_resultSet.getString("USERNAME"));
                Role actualRole;
                actualRole = new Role();
                actualRole.setId(var_resultSet.getInt("ROLE_ID"));
                actualRole.setName(var_resultSet.getString("ROLE_NAME"));
                userBean.setRole(actualRole);
            }
            return userBean;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void updateUser(User vUser) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_UPDATE_USER);
            //Colocamos los parametros de la consulta
            statement.setInt(1, vUser.getId());
            statement.setString(2, vUser.getUserName());
            statement.setString(3, vUser.getPassword());
            statement.setInt(4, vUser.getRole().getId());
            //ejecutamos la consulta
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOVendor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteUser(int userId) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_DELETE_USER);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser(String username, String password) {
        try {
            User userBean = new User();
            userBean.setUserName(username);
            userBean.setPassword(password);

            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_USER);
            statement.setString(1, userBean.getUserName());
            statement.setString(2, userBean.getPassword());
            ResultSet var_resultSet = statement.executeQuery();
            var_resultSet.next();
            if (var_resultSet.getString("USER_EXISTS").equals("TRUE")){
                return userBean;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return null; // error del sistema
        }
    }

}
