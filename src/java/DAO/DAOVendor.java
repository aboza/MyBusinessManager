/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Customer;
import Beans.Vendor;
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
public class DAOVendor {
    
    public ArrayList<Vendor> getAllVendors() {
        try {
            ArrayList<Vendor> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GETVENDORS);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                Vendor actualVendor;
                actualVendor = new Vendor();
                actualVendor.setId(var_resultSet.getInt("VENDOR_ID"));
                actualVendor.setName(var_resultSet.getString("NAME"));
                actualVendor.setCompanyName(var_resultSet.getString("COMPANY_NAME"));
                actualVendor.setPhone(var_resultSet.getString("PHONE"));
                actualVendor.setFax(var_resultSet.getString("FAX"));
                actualVendor.setEmail(var_resultSet.getString("EMAIL"));
                actualVendor.setAltphone(var_resultSet.getString("ALT_PHONE"));
                actualVendor.setAddress(var_resultSet.getString("ADDRESS"));
                actualVendor.setVendorType(var_resultSet.getString("VENDOR_TYPE"));
                resultList.add(actualVendor);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
