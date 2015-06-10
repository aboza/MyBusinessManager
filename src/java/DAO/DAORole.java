/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Permission;
import Beans.Role;
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
public class DAORole {

    public ArrayList<Role> getAllRoles() {
        try {
            ArrayList<Role> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ROLES);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                Role actualRole;
                actualRole = new Role();
                actualRole.setId(var_resultSet.getInt("ROLE_ID"));
                actualRole.setName(var_resultSet.getString("NAME"));
                actualRole.setPermisssions(getPermissionsByRole(actualRole.getId()));
                resultList.add(actualRole);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Role getSingleRoleById(int roleId) {
        try {
            Role roleBean = null;
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ROLE_BY_ID);
            statement.setInt(1, roleId);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                roleBean = new Role();
                roleBean.setId(var_resultSet.getInt("ROLE_ID"));
                roleBean.setName(var_resultSet.getString("NAME"));
                roleBean.setPermisssions(getPermissionsByRole(roleBean.getId()));
            }
            return roleBean;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Permission> getPermissionsByRole(int roleId) {
        try {
            ArrayList<Permission> permissions = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_PERMISSIONS);
            statement.setInt(1, roleId);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                Permission actualPermission = new Permission();
                actualPermission.setId(var_resultSet.getInt("PERMISSION_ID"));
                actualPermission.setCode(var_resultSet.getString("CODE"));
                actualPermission.setDescription(var_resultSet.getString("DESCRIPTION"));
                permissions.add(actualPermission);
            }
            return permissions;
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public void deleteRole(int roleId) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_DELETE_ROLE);
            statement.setInt(1, roleId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOVendor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
