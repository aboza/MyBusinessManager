/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Receipt;
import Beans.Customer;
import Beans.ReceiptDetail;
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
public class DAOReceipt {
    
    public ArrayList<Receipt> getAllReceipts() {
        try {
            ArrayList<Receipt> resultList = new ArrayList<>();
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_ALL_RECEIPTS);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                Receipt actualReceipt;
                actualReceipt = new Receipt();
                actualReceipt.setId(var_resultSet.getInt("RECEIPT_ID"));
                actualReceipt.setNumber(var_resultSet.getInt("RECEIPT_NUMBER"));
                actualReceipt.setDate(var_resultSet.getDate("RECEIPT_DATE"));
                actualReceipt.setPaymentMethod(var_resultSet.getString("PAYMENT_METHOD"));
                actualReceipt.setObservations(var_resultSet.getString("OBSERVATIONS"));
                actualReceipt.setDiscount(var_resultSet.getInt("DISCOUNT"));
                actualReceipt.setTax(var_resultSet.getInt("TAX"));
                actualReceipt.setTotal(var_resultSet.getInt("TOTAL"));
                actualReceipt.setSubtotal(var_resultSet.getInt("SUBTOTAL"));
                actualReceipt.setPosted(var_resultSet.getBoolean("POSTED"));
                ////////////crea un nuevo arrayList y hace una nueva consulta
                ////////////guarda informacion de los detalles de la factura
                ArrayList<ReceiptDetail> listaDetalles = new ArrayList<>();
                OracleConnectionFactory connection2 = new OracleConnectionFactory();
                PreparedStatement statement2 = connection2.getConnection().prepareStatement(Constants.ORACLE_GET_RECEIPT_DETAILS_BY_RECEIPT_ID);
                statement2.setInt(1, actualReceipt.getId());
                ResultSet setResultados = statement2.executeQuery();
                while (setResultados.next()) {
                    ReceiptDetail actualReceiptDetail;
                    actualReceiptDetail = new ReceiptDetail();
                    actualReceiptDetail.setItemID(setResultados.getInt("ITEM_ID"));
                    actualReceiptDetail.setQuantity(setResultados.getInt("QUANTITY"));
                    actualReceiptDetail.setTax(setResultados.getInt("TAX"));
                    actualReceiptDetail.setCost(setResultados.getInt("COST"));
                    actualReceiptDetail.setTotalAmount(setResultados.getInt("TOTAL_AMOUNT"));
                    actualReceiptDetail.setDiscount(setResultados.getInt("DISCOUNT"));
                    listaDetalles.add(actualReceiptDetail);
                }
                ////////////termina detalles de factura
                ////////////consulta de cliente en la factura
                Customer cliente = new Customer();
                OracleConnectionFactory connection3 = new OracleConnectionFactory();
                PreparedStatement statement3 = connection3.getConnection().prepareStatement(Constants.ORACLE_GET_CUSTOMER_BY_ID);
                statement3.setInt(1, var_resultSet.getInt("CUSTOMER_ID"));
                ResultSet resultadosCliente = statement3.executeQuery();
                while (resultadosCliente.next()) {
                    cliente.setId(resultadosCliente.getInt("CUSTOMER_ID"));
                    cliente.setName(resultadosCliente.getString("NAME"));
                    cliente.setCompanyName(resultadosCliente.getString("COMPANY_NAME"));
                    cliente.setPhone(resultadosCliente.getString("PHONE"));
                    cliente.setFax(resultadosCliente.getString("FAX"));
                    cliente.setEmail(resultadosCliente.getString("EMAIL"));
                    cliente.setBillTo(resultadosCliente.getString("BILL_TO"));
                    cliente.setShipTo(resultadosCliente.getString("SHIP_TO"));
                    cliente.setTerms(resultadosCliente.getString("TERMS"));
                }
                ////////////fin consulta de cliente
                ////////////
                actualReceipt.setCustomer(cliente);
                actualReceipt.setDetails(listaDetalles);
                resultList.add(actualReceipt);
            }
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOReceipt.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public Receipt getSingleReceiptById(int receiptId) {
        try {
            Receipt receiptBean = null;
            OracleConnectionFactory connection = new OracleConnectionFactory();
            PreparedStatement statement = connection.getConnection().prepareStatement(Constants.ORACLE_GET_RECEIPT_BY_RECEIPT_ID);
            statement.setInt(1, receiptId);
            ResultSet var_resultSet = statement.executeQuery();
            while (var_resultSet.next()) {
                receiptBean = new Receipt();
                receiptBean.setId(var_resultSet.getInt("RECEIPT_ID"));
                receiptBean.setNumber(var_resultSet.getInt("RECEIPT_NUMBER"));
                receiptBean.setDate(var_resultSet.getDate("RECEIPT_DATE"));
                receiptBean.setPaymentMethod(var_resultSet.getString("PAYMENT_METHOD"));
                receiptBean.setObservations(var_resultSet.getString("OBSERVATIONS"));
                receiptBean.setDiscount(var_resultSet.getInt("DISCOUNT"));
                receiptBean.setTax(var_resultSet.getInt("TAX"));
                receiptBean.setTotal(var_resultSet.getInt("TOTAL"));
                receiptBean.setSubtotal(var_resultSet.getInt("SUBTOTAL"));
                receiptBean.setPosted(var_resultSet.getBoolean("POSTED"));
                ////////////crea un nuevo arrayList y hace una nueva consulta
                ////////////guarda informacion de los detalles de la factura
                ArrayList<ReceiptDetail> listaDetalles = new ArrayList<>();
                OracleConnectionFactory connection2 = new OracleConnectionFactory();
                PreparedStatement statement2 = connection2.getConnection().prepareStatement(Constants.ORACLE_GET_RECEIPT_DETAILS_BY_RECEIPT_ID);
                statement2.setInt(1, receiptBean.getId());
                ResultSet setResultados = statement2.executeQuery();
                while (setResultados.next()) {
                    ReceiptDetail actualReceiptDetail;
                    actualReceiptDetail = new ReceiptDetail();
                    actualReceiptDetail.setItemID(setResultados.getInt("ITEM_ID"));
                    actualReceiptDetail.setQuantity(setResultados.getInt("QUANTITY"));
                    actualReceiptDetail.setTax(setResultados.getInt("TAX"));
                    actualReceiptDetail.setCost(setResultados.getInt("COST"));
                    actualReceiptDetail.setTotalAmount(setResultados.getInt("TOTAL_AMOUNT"));
                    actualReceiptDetail.setDiscount(setResultados.getInt("DISCOUNT"));
                    listaDetalles.add(actualReceiptDetail);
                }
                ////////////termina detalles de factura
                ////////////consulta de cliente en la factura
                Customer cliente = new Customer();
                OracleConnectionFactory connection3 = new OracleConnectionFactory();
                PreparedStatement statement3 = connection3.getConnection().prepareStatement(Constants.ORACLE_GET_CUSTOMER_BY_ID);
                statement3.setInt(1, var_resultSet.getInt("CUSTOMER_ID"));
                ResultSet resultadosCliente = statement3.executeQuery();
                while (resultadosCliente.next()) {
                    cliente.setId(resultadosCliente.getInt("CUSTOMER_ID"));
                    cliente.setName(resultadosCliente.getString("NAME"));
                    cliente.setCompanyName(resultadosCliente.getString("COMPANY_NAME"));
                    cliente.setPhone(resultadosCliente.getString("PHONE"));
                    cliente.setFax(resultadosCliente.getString("FAX"));
                    cliente.setEmail(resultadosCliente.getString("EMAIL"));
                    cliente.setBillTo(resultadosCliente.getString("BILL_TO"));
                    cliente.setShipTo(resultadosCliente.getString("SHIP_TO"));
                    cliente.setTerms(resultadosCliente.getString("TERMS"));
                }
                ////////////fin consulta de cliente
                ////////////
                receiptBean.setCustomer(cliente);
                receiptBean.setDetails(listaDetalles);
            }
            return receiptBean;
        } catch (SQLException ex) {
            Logger.getLogger(DAOReceipt.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
     
     
    
}
