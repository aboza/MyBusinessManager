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
    
    
    
        //Devolve todo el inventario de todas las bodegas 
        public ArrayList<WareHouse> getWarehouse() {
        try {
            ArrayList<WareHouse> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ALL_INVENTORY);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                WareHouse actualWareHouse;
                actualWareHouse = new WareHouse();
                actualWareHouse.setName(var_resultSet.getString("name"));                
                actualWareHouse.setAddress(var_resultSet.getString("address"));
                System.out.println(actualWareHouse.getName());
                

                Item actualItem;
                actualItem = new Item();
                actualItem.setName(var_resultSet.getString("name_item"));
                actualItem.setCode(var_resultSet.getString("code"));
                actualItem.setDescription(var_resultSet.getString("description"));
                actualItem.setCost (var_resultSet.getFloat("cost_per_unit"));
                actualItem.setReOrderPoint(var_resultSet.getInt("reorder_point"));
                actualItem.setOnHand(var_resultSet.getInt("on_hand"));
                
                ArrayList<Item> lista = new ArrayList<>();
                lista.add(actualItem);

                actualWareHouse.setInventory(lista);
                resultList.add(actualWareHouse);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOWareHouse.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        // Devuelve todos los nombres de las bodegas
        public ArrayList<WareHouse> getAllWarehouse() {
        try {
            ArrayList<WareHouse> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ALL_WareHouse);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                WareHouse actualWareHouse;
                actualWareHouse = new WareHouse();
                actualWareHouse.setName(var_resultSet.getString("name"));                
                resultList.add(actualWareHouse);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOWareHouse.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        //Buscar un especifica Bodega y devuelve el inventario de ella
        public ArrayList<WareHouse> getWarehouseName(String wareHouseName) {
        try {
            ArrayList<WareHouse> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_INVENTORY_WAREHOUSENAME);
            statement.setString(1, wareHouseName);
            ResultSet var_resultSet = statement.executeQuery();
            
            while (var_resultSet.next()) {
               WareHouse actualWareHouse;
                actualWareHouse = new WareHouse();
                actualWareHouse.setName(var_resultSet.getString("name"));                
                actualWareHouse.setAddress(var_resultSet.getString("address"));
                
                Item actualItem;
                actualItem = new Item();           
                actualItem.setName(var_resultSet.getString("name_item"));
                System.out.println(actualItem.getName() + "--------------------------paso");
                actualItem.setCode(var_resultSet.getString("code"));
                actualItem.setDescription(var_resultSet.getString("description"));
                actualItem.setCost (var_resultSet.getFloat("cost_per_unit"));
                actualItem.setReOrderPoint(var_resultSet.getInt("reorder_point"));
                actualItem.setOnHand(var_resultSet.getInt("on_hand"));
                
                ArrayList<Item> lista = new ArrayList<>();
                lista.add(actualItem);

                actualWareHouse.setInventory(lista);
                resultList.add(actualWareHouse);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOWareHouse.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }        
        
        
        
        
}