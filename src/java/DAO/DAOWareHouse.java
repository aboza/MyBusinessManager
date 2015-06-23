/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Item;
import Beans.WareHouse;
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
 * @author Rafael
 */
public class DAOWareHouse {
    
        public ArrayList<WareHouse> getWarehouse() {
        try {
            ArrayList<WareHouse> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ALL_WAREHOUSE);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                WareHouse actualWareHouse;
                actualWareHouse = new WareHouse();
                actualWareHouse.setName(var_resultSet.getString("WAREHOUSE_NAME"));
                actualWareHouse.setAddress(var_resultSet.getString("WAREHOUSE_addr"));
                
                Item actualItem;
                actualItem = new Item();
                actualItem.setName(var_resultSet.getString("ITEM_NAME"));
                actualItem.setCode(var_resultSet.getString("ITEM_CODE"));
                actualItem.setDescription(var_resultSet.getString("ITEM_DESCR"));
                actualItem.setCost (var_resultSet.getFloat("ITEM_Costo"));
                actualItem.setReOrderPoint(var_resultSet.getInt("ITEM_REORDER"));
                actualItem.setOnHand(var_resultSet.getInt("ITEM_ONHAND"));
                
//                actualWareHouse.setInventory(actualItem);
                
                
                resultList.add(actualWareHouse);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOWareHouse.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}