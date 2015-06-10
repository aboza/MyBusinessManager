/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ALL_VENDORS);
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

    public Vendor getSingleVendorById(int vendorId) {
        try {
            Vendor vendorBean = null;
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_VENDOR_BY_ID);
            statement.setInt(1, vendorId);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                vendorBean = new Vendor();
                vendorBean.setId(var_resultSet.getInt("VENDOR_ID"));
                vendorBean.setName(var_resultSet.getString("NAME"));
                vendorBean.setContact(var_resultSet.getString("CONTACT"));
                vendorBean.setCompanyName(var_resultSet.getString("COMPANY_NAME"));
                vendorBean.setPhone(var_resultSet.getString("PHONE"));
                vendorBean.setFax(var_resultSet.getString("FAX"));
                vendorBean.setEmail(var_resultSet.getString("EMAIL"));
                vendorBean.setAltphone(var_resultSet.getString("ALT_PHONE"));
                vendorBean.setAddress(var_resultSet.getString("ADDRESS"));
                vendorBean.setVendorType(var_resultSet.getString("VENDOR_TYPE"));
            }
            return vendorBean;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void updateVendor(Vendor vVendor) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_UPDATE_VENDOR);
            //Colocamos los parametros de la consulta
            statement.setInt(1, vVendor.getId());
            statement.setString(2, vVendor.getName());
            statement.setString(3, vVendor.getCompanyName());
            statement.setString(4, vVendor.getContact());
            statement.setString(5, vVendor.getPhone());
            statement.setString(6, vVendor.getAltphone());
            statement.setString(7, vVendor.getFax());
            statement.setString(8, vVendor.getEmail());
            statement.setString(9, vVendor.getVendorType());
            statement.setString(10, vVendor.getAddress());
            //ejecutamos la consulta
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOVendor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteVendor(int vendorId) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_DELETE_VENDOR);
            statement.setInt(1, vendorId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOVendor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createVendor(Vendor vVendor) {
        try {
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_CREATE_VENDOR);
            //Colocamos los parametros de la consulta
            statement.setString(1, vVendor.getName());
            statement.setString(2, vVendor.getCompanyName());
            statement.setString(3, vVendor.getContact());
            statement.setString(4, vVendor.getPhone());
            statement.setString(5, vVendor.getAltphone());
            statement.setString(6, vVendor.getFax());
            statement.setString(7, vVendor.getEmail());
            statement.setString(8, vVendor.getVendorType());
            statement.setString(9, vVendor.getAddress());
            //ejecutamos la consulta
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOVendor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
