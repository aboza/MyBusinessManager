/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Customer;
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
public class DAOCustomer {
    
    public ArrayList<Customer> getAllCustomers() {
        try {
            ArrayList<Customer> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GETCUSTOMERS);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                Customer actualCustomer;
                actualCustomer = new Customer();
                actualCustomer.setId(var_resultSet.getInt("CUSTOMER_ID"));
                actualCustomer.setName(var_resultSet.getString("NAME"));
                actualCustomer.setCompanyName(var_resultSet.getString("COMPANY_NAME"));
                actualCustomer.setPhone(var_resultSet.getString("PHONE"));
                actualCustomer.setFax(var_resultSet.getString("FAX"));
                actualCustomer.setEmail(var_resultSet.getString("EMAIL"));
                actualCustomer.setBillTo(var_resultSet.getString("BILL_TO"));
                actualCustomer.setShipTo(var_resultSet.getString("SHIP_TO"));
                actualCustomer.setTerms(var_resultSet.getString("TERMS"));
                resultList.add(actualCustomer);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
}
