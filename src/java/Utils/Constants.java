/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author AlexisDev
 */
public final class Constants {

    public static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static String ORACLE_SERVER_INSTANCE = "jdbc:oracle:thin:@localhost:1521/";
    public static String ORACLE_PDB_SID = "pdborcl";
    public static String ORACLE_PDB_USER = "BusinessManager_DB";
    public static String ORACLE_PDB_PASSWORD = "ORCL1234";

    //queries
    //Oracle al parecer no puede hacer Procedures de SELECT -_-
    public static String ORACLE_GET_ALL_CUSTOMERS = "SELECT CUSTOMER_ID ,NAME,COMPANY_NAME,"
            + "PHONE,FAX,EMAIL,BILL_TO,SHIP_TO,TERMS FROM BM_CUSTOMERS";
    public static String ORACLE_GET_ALL_VENDORS = "SELECT VENDOR_ID,NAME,COMPANY_NAME,CONTACT,"
            + "VENDOR_TYPE,ADDRESS,PHONE,ALT_PHONE,FAX,EMAIL FROM BM_VENDORS";
    public static String ORACLE_GET_CUSTOMER_BY_ID = "SELECT CUSTOMER_ID ,NAME,COMPANY_NAME,"
            + "PHONE,FAX,EMAIL,BILL_TO,SHIP_TO,TERMS FROM BM_CUSTOMERS WHERE CUSTOMER_ID = ?";
    public static String ORACLE_GET_VENDOR_BY_ID = "SELECT VENDOR_ID,NAME,COMPANY_NAME,CONTACT,"
            + "VENDOR_TYPE,ADDRESS,PHONE,ALT_PHONE,FAX,EMAIL FROM BM_VENDORS WHERE VENDOR_ID = ?";
    public static String ORACLE_GET_ROLES = "SELECT ROLE_ID ,NAME FROM BM_ROLES";
    public static String ORACLE_GET_ROLE_BY_ID = "SELECT ROLE_ID ,NAME FROM BM_ROLES WHERE ROLE_ID = ?";
    public static String ORACLE_GET_PERMISSIONS = "SELECT P.PERMISSION_ID,P.CODE,P.DESCRIPTION FROM BM_PERMISSIONS P"
            + " INNER JOIN BM_PERMISSIONSXROLE PXR ON PXR.PERMISSION_ID = P.PERMISSION_ID"
            + " WHERE PXR.ROLE_ID = ?";
    public static String ORACLE_GET_USERS = "SELECT U.USER_ID,U.USERNAME,U.ROLE_ID,R.NAME AS ROLE_NAME "
            + "FROM BM_USERS U INNER JOIN BM_ROLES R ON  R.ROLE_ID = U.ROLE_ID";
    public static String ORACLE_GET_USER_BY_ID = "SELECT U.USER_ID,U.USERNAME,U.ROLE_ID,R.NAME AS ROLE_NAME "
            + "FROM BM_USERS U INNER JOIN BM_ROLES R ON  R.ROLE_ID = U.ROLE_ID WHERE USER_ID = ?";
    public static String ORACLE_GET_USER = "SELECT user_exists(?,?) AS USER_EXISTS FROM dual";
    
    public static String ORACLE_GET_CASHIERS = "SELECT CASHIER_ID ,NAME FROM BM_CASHIERS";
    public static String ORACLE_GET_CASHIER_BY_ID = "SELECT CASHIER_ID ,NAME FROM BM_CASHIERS WHERE CASHIER_ID = ?";

    //procedures calls
    public static String ORACLE_UPDATE_VENDOR = "CALL UPDATE_Vendor(?,?,?,?,?,?,?,?,?,?)";
    public static String ORACLE_CREATE_VENDOR = "CALL CREATE_Vendor(?,?,?,?,?,?,?,?,?)";
    public static String ORACLE_DELETE_VENDOR = "CALL DELETE_Vendor(?)";

    public static String ORACLE_UPDATE_CUSTOMER = "CALL UPDATE_Customer(?,?,?,?,?,?,?,?,?)";
    public static String ORACLE_CREATE_CUSTOMER = "CALL CREATE_Customer(?,?,?,?,?,?,?,?)";
    public static String ORACLE_DELETE_CUSTOMER = "CALL DELETE_Customer(?)";

    public static String ORACLE_DELETE_ROLE = "CALL DELETE_Role(?)";

    public static String ORACLE_CREATE_USER = "CALL CREATE_User(?,?,?)";
    public static String ORACLE_UPDATE_USER = "CALL UPDATE_User(?,?,?,?)";
    public static String ORACLE_DELETE_USER = "CALL DELETE_User(?)";
    
    public static String ORACLE_USER_HAS_ACTION_PRIVILEGE = "SELECT USER_HAS_PRIVILEGE(?,?) AS HAS_PRIVELEGE FROM dual";
    
    public static String ORACLE_CREATE_CASHIER = "CALL CREATE_Cashier(?)";
    public static String ORACLE_UPDATE_CASHIER = "CALL UPDATE_Cashier(?,?)";
    public static String ORACLE_DELETE_CASHIER = "CALL DELETE_Cashier(?)";
    
    
    public  static  String ORACLE_GET_ALL_WAREHOUSE = "Select c.name , c.address, b.name, b.code,"
            + " b.description, b.cost_per_unit,b.reorder_point,b.on_hand from "
            + "BUSINESSMANAGER_DB.bm_inventory A,BUSINESSMANAGER_DB.bm_items B ,"
            + "BUSINESSMANAGER_DB.bm_warehouses C " 
            + "where a.warehouse_id = c.warehouse_id and b.item_id = a.item_id;";
    
    

}
