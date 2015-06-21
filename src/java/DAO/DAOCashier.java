/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Cashier;
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
 * @author Glenn
 */
public class DAOCashier {
    
    
    public ArrayList<Cashier> getAllCashiers() {
        try {
            ArrayList<Cashier> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_CASHIERS);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                Cashier actualCashier;
                actualCashier = new Cashier();
                actualCashier.setId(var_resultSet.getInt("CASHIER_ID"));
                actualCashier.setName(var_resultSet.getString("NAME"));
                resultList.add(actualCashier);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Cashier getSingleCashierById(int cashierId) {
        try {
            Cashier cashierBean = null;
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_CASHIER_BY_ID);
            statement.setInt(1, cashierId);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                cashierBean = new Cashier();
                cashierBean.setId(var_resultSet.getInt("CASHIER_ID"));
                cashierBean.setName(var_resultSet.getString("NAME"));
            }
            return cashierBean;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void updateCashier(Cashier cCashier) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_UPDATE_CASHIER);
            //Colocamos los parametros de la consulta
            statement.setInt(1, cCashier.getId());
            statement.setString(2, cCashier.getName());
            //ejecutamos la consulta
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCashier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteCashier(int cashierId) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_DELETE_CASHIER);
            statement.setInt(1, cashierId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createCashier(Cashier cCashier) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_CREATE_CASHIER);
            //Colocamos los parametros de la consulta
            statement.setString(1, cCashier.getName());
            //ejecutamos la consulta
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCashier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
